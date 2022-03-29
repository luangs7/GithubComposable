plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.data.repository)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitConverter)
    implementation(Dependencies.retrofitLogger)
}