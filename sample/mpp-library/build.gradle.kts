/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("com.android.library")
    id("dev.icerock.moko.gradle.android.base")
    id("org.jetbrains.kotlin.multiplatform")
    id("dev.icerock.mobile.multiplatform.targets")
    id("dev.icerock.mobile.multiplatform.ios-framework")
    id("dev.icerock.moko.gradle.detekt")
}

dependencies {
    commonMainApi(libs.coroutines)

    commonMainApi(projects.utils)
}

framework {
    export(projects.utils)
}
