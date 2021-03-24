/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    jcenter()

    maven { url = uri("https://dl.bintray.com/icerockdev/plugins") }
}

dependencies {
    implementation("dev.icerock:mobile-multiplatform:0.9.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.31")
    implementation("com.android.tools.build:gradle:4.1.2")
}
