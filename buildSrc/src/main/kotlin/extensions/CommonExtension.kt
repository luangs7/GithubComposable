package extensions

import com.android.build.api.dsl.CommonExtension

fun CommonExtension<*, *, *, *>.addDefaultConfig() {
    compileSdk = ConfigData.compileSdkVersion
    defaultConfig {
        compileSdk = ConfigData.compileSdkVersion
        minSdk = ConfigData.minSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

fun CommonExtension<*, *, *, *>.addComposeConfig() {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeVersion
    }

    packagingOptions {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
}

fun CommonExtension<*, *, *, *>.configureBuildTypes() {
    buildTypes {
        getByName("release") {
            buildConfigField("Boolean","IS_MOCK","false")
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        create("mock"){
            buildConfigField("Boolean","IS_MOCK","true")
            isMinifyEnabled = ConfigData.minifyEnable
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}