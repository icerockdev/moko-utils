/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlin.native.concurrent.WorkerBoundReference
import kotlin.native.concurrent.ensureNeverFrozen
import kotlin.native.concurrent.freeze

actual fun <R> callOnDispatcherWithoutFreeze(
    dispatcher: CoroutineDispatcher,
    block: suspend () -> R
): suspend () -> R {
    // mark that block should not be frozen
    block.ensureNeverFrozen()
    // this reference will be frozen, but block not freeze
    val guardRef = WorkerBoundReference(block)
    val result: suspend () -> R = {
        withContext(dispatcher) {
            val guardedBlock = guardRef.value
            guardedBlock()
        }
    }
    // freeze lambda to check that all ok
    result.freeze()
    return result
}
