/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.utils

import platform.Foundation.NSThread

actual fun printThread() {
    println("Current thread: ${NSThread.currentThread}")
}
