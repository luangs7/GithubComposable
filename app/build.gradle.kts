import extensions.*

plugins {
    id(GradlePlugin.ANDROID_APPLICATION)
    id(GradlePlugin.KOTLIN_ANDROID)
    id(GradlePlugin.COMPOSE)
    kotlin("kapt")
}

repositories {
    jcenter()
}

android {
    addDefaultConfig()
    defaultConfig {
        applicationId = ConfigData.applicationId
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
        targetSdk = ConfigData.targetSdkVersion
    }
    configureBuildTypes()
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.domain)
    implementation(projects.presentation)
    implementation(projects.core.designsystem)
    implementation(projects.data.local)
    implementation(projects.data.remote)
    implementation(projects.data.repository)
    implementation(projects.library.navigation)
    addKoinDependencies()
    addCoroutinesDependencies()
    addCommonDependencies()
}