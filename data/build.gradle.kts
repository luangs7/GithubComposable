plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
}

dependencies {
    implementation(projects.common)
    implementation(projects.domain)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.room)
    implementation(Dependencies.roomCoroutines)
    implementation(Dependencies.retrofitConverter)
    annotationProcessor(AnnotationProcessor.room)
}