/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

actual fun <R> callOnDispatcherWithoutFreeze(
    dispatcher: CoroutineDispatcher,
    block: suspend () -> R
): suspend () -> R {
    return {
        withContext(dispatcher) {
            block()
        }
    }
}
