/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.utils

import kotlin.native.concurrent.TransferMode
import kotlin.native.concurrent.Worker
import kotlin.native.concurrent.WorkerBoundReference
import kotlin.native.concurrent.ensureNeverFrozen
import kotlin.native.concurrent.freeze

actual fun <R> callOnCurrentWorkerWithoutFreeze(block: () -> R): () -> R {
    // mark that block should not be frozen
    block.ensureNeverFrozen()
    // this reference will be frozen, but block not freeze
    val guardRef = WorkerBoundReference(block)
    val current = Worker.current
    val result: () -> R = {
        current.execute(
            mode = TransferMode.SAFE,
            producer = {
                guardRef
            },
            job = {
                val guardedBlock = it.value
                guardedBlock()
            }
        ).consume { it }
    }
    // freeze lambda to check that all ok
    result.freeze()
    return result
}
