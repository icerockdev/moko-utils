/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()

        maven { url = uri("https://dl.bintray.com/icerockdev/plugins") }

        jcenter()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()

        maven { url = uri("https://dl.bintray.com/icerockdev/moko") }

        jcenter()
    }
}

include(":utils")
include(":sample:android-app")
include(":sample:mpp-library")
