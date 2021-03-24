/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.utils

import kotlin.native.ref.WeakReference

actual fun <T : Any> weakLambda(
    obj: T,
    block: T.() -> Unit
): () -> Unit {
    val weakThis: WeakReference<T> = WeakReference(obj)
    return result@{
        val strongThis = weakThis.get() ?: return@result

        strongThis.block()
    }
}

actual fun <T : Any, A1> weakLambda1(
    obj: T,
    block: T.(A1) -> Unit
): (A1) -> Unit {
    val weakThis: WeakReference<T> = WeakReference(obj)
    return result@{
        val strongThis = weakThis.get() ?: return@result

        strongThis.block(it)
    }
}
