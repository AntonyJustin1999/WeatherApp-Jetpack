package com.weather.app.build.dependencies

object Libraries {
    //const val classPathGradle = "com.android.tools.build:gradle:${Versions.ClassPathGradleVersion}"
    //const val classPathKotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KotlinVersion}"

    //Kotlin
    //const val kotlinStandardLibraryJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    //Core
    const val coreKtx = "androidx.core:core-ktx:${Versions.CoreKtxVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.AppCompatVersion}"
    //Compose UI
    const val composeUI = "androidx.compose.ui:ui:${Versions.ComposeUIVersion}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.ComposeMaterialVersion}"
    const val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.ComposeUIToolingPreviewVersion}"
    //Architecture
    const val lifeCycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.LifeCycleViewModelVersion}"
    const val lifeCycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LifeCycleRuntimeKtxVersion}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.ActivityComposeVersion}"
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.NavigationComposeVersion}"
    const val composeUITooling = "androidx.compose.ui:ui-tooling:${Versions.composeUIToolingVersion}"
    //Material
    const val material3 = "androidx.compose.material3:material3:${Versions.material3Version}"
    //DataStore
    const val datastore = "androidx.datastore:datastore:${Versions.dataStore}"
    const val datastorePreference = "androidx.datastore:datastore-preferences:${Versions.dataStore}"
    //Network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val okHttpGsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitConverterGson}"
    //Hilt
    const val hilt ="com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"
    const val hiltWork = "androidx.hilt:hilt-work:${Versions.hiltWork}"

    const val kaptHiltAndroidCompiler="com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val kaptHiltCompiler="androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
    const val workManagerKtx= "androidx.work:work-runtime-ktx:${Versions.workManagerKtx}"

}