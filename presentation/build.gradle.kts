plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.COMPOSE_LIBRARY)
}
dependencies {
    implementation(projects.core.common)
    implementation(projects.domain)
    implementation(projects.core.designsystem)
    implementation(projects.library.navigation)
}