package gradle

import extensions.addDefaultConfig
import extensions.addCommonDependencies
import extensions.addKoinDependencies
import extensions.addCoroutinesDependencies
import extensions.configureBuildTypes

plugins {
    id("com.android.library")
    id("kotlin-android")
}

repositories {
    jcenter()
}

android {
    addDefaultConfig()
    configureBuildTypes()
}

dependencies{
    addCommonDependencies()
    addCoroutinesDependencies()
    addKoinDependencies()
}

