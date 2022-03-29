object Versions {
    const val gradlePlugin = "4.2.1"
    const val kotlin = "1.6.10"
    const val appCompat = "1.3.0"
    const val material = "1.3.0"
    const val constraintLayout = "1.1.3"
    const val circleimageview = "3.0.0"
    const val koin = "3.2.0-beta-1"
    const val retrofit = "2.7.1"
    const val retrofitConverter = "2.9.0"
    const val retrofitLogging = "4.9.0"
    const val lifecycle = "2.2.0"
    const val room = "2.4.0"
    const val jUnit = "4.12"
    const val jUnitExt = "1.1.3"
    const val androidxRunner = "1.1.1"
    const val androidxRules = "1.1.0"
    const val androidxExpresso = "3.3.0"
    const val androidxCore = "1.4.0"
    const val mockK = "1.9.3"
    const val coroutines = "1.4.2"
    const val coreTesting = "2.0.1"
    const val composeVersion = "1.2.0-alpha01"
    const val composeActivity = "1.4.0"
    const val lifecycleKtx = "2.4.1"
    const val lifecycleCompiler = "2.3.0"
    const val navigationCompose = "2.4.1"
    const val coilKt = "2.0.0-rc02"
}

object Dependencies {
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val materialDesign = "com.google.android.material:material:${Versions.material}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val junit = "junit:junit:${Versions.jUnit}"
    val lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
    val circleimageview = "de.hdodenhof:circleimageview:${Versions.circleimageview}"
    val room = "androidx.room:room-runtime:${Versions.room}"
    val roomCoroutines = "androidx.room:room-ktx:${Versions.room}"
    val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    val composeMaterial = "androidx.compose.material:material:${Versions.composeVersion}"
    val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
    val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}"
    val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
    val retrofitConverter  = "com.squareup.retrofit2:converter-gson:${Versions.retrofitConverter}"
    val retrofitLogger  = "com.squareup.okhttp3:logging-interceptor:${Versions.retrofitLogging}"
    val coilKt  = "io.coil-kt:coil-compose:${Versions.coilKt}"
}


object AnnotationProcessor {
    val room = "androidx.room:room-compiler:${Versions.room}"
    val lifecycle = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleCompiler}"
}

object Tests {
    val koinTest = "org.koin:koin-test:${Versions.koin}"
    val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    val mockk = "io.mockk:mockk:${Versions.mockK}"
    val androidxCore = "androidx.test:core:${Versions.androidxCore}"
    val jUnit = "junit:junit:${Versions.jUnit}"
    val jUnitExt = "androidx.test.ext:junit:${Versions.jUnit}"
    val kotlinX = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}

