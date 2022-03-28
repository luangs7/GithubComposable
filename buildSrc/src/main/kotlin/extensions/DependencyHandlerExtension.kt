package extensions

import org.gradle.api.Action
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo
import org.gradle.kotlin.dsl.exclude

/**
 * Adds the Compose dependencies on Gradle.
 */

fun DependencyHandler.addCommonDependencies() {
    implementation(Dependencies.lifecycle)
    implementation(Dependencies.kotlin)
    testImplementation(Tests.jUnit)
    annotationProcessor(AnnotationProcessor.lifecycle)
}

fun DependencyHandler.addKoinDependencies(){
    implementation(Dependencies.koinAndroid)
    implementation(Dependencies.koinAndroidViewModel)
    implementation(Dependencies.koinAndroidScope)
}

fun DependencyHandler.addDesignDependencies() {
    api(Dependencies.appCompat)
    api(Dependencies.constraintLayout)
    api(Dependencies.materialDesign)
    api(Dependencies.circleimageview)
    api(Dependencies.lifecycleKtx)
}

fun DependencyHandler.addComposeDependencies(){
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.composeActivity)
    implementation(Dependencies.navigationCompose)
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.1")
}

fun DependencyHandler.addCoroutinesDependencies(){
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutinesAndroid)
}

private fun DependencyHandler.api(dependencyNotation: String): Dependency? =
    add("api", dependencyNotation)

private fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
    add("implementation", dependencyNotation)

private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

private fun DependencyHandler.androidTestApi(dependencyNotation: Any): Dependency? =
    add("androidTestApi", dependencyNotation)

private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

private fun DependencyHandler.annotationProcessor(dependencyNotation: Any): Dependency? =
    add("annotationProcessor", dependencyNotation)

private fun DependencyHandler.androidTestImplementation(
    dependencyNotation: String,
    dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
    this, "androidTestImplementation", dependencyNotation, dependencyConfiguration
)