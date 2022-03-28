plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.COMPOSE_LIBRARY)
}
dependencies {
    implementation(projects.common)
    implementation(projects.domain)
    implementation(projects.designsystem)
}