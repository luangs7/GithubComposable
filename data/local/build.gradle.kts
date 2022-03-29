import extensions.addRoomDependencies

plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
}

dependencies {
    implementation(projects.data.repository)
    addRoomDependencies()
}