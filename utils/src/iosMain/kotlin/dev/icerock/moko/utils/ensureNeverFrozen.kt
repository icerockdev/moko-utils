/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.utils

import kotlin.native.concurrent.ensureNeverFrozen

actual inline fun Any.ensureNeverFrozen() {
    this.ensureNeverFrozen()
}
