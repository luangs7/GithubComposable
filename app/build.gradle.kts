import extensions.*

plugins {
    id(GradlePlugin.ANDROID_APPLICATION)
    id(GradlePlugin.KOTLIN_ANDROID)
    id(GradlePlugin.COMPOSE)
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
    implementation(projects.common)
    implementation(projects.domain)
    implementation(projects.presentation)
    implementation(projects.designsystem)
    addKoinDependencies()
    addCoroutinesDependencies()
    addCommonDependencies()
}