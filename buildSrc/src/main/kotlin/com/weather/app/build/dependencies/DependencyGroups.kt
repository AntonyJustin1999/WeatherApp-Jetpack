package com.weather.app.build.dependencies


//internal val kotlinDependencies = listOf(
//    Libraries.kotlinStandardLibraryJdk8,
////    Libraries.coroutinesCore,
////    Libraries.coroutinesAndroid
//)

internal val workManagerDependencies = listOf(
    Libraries.workManagerKtx,
)

internal val coreDependencies = listOf(
    Libraries.coreKtx,
    Libraries.appCompat,
)

internal val composeOfficialDependencies = listOf(
    Libraries.composeUI,
    Libraries.composeMaterial,
    Libraries.composeUIToolingPreview,
    Libraries.activityCompose,
    Libraries.navigationCompose,
)

internal val composeUIToolingDependencies = listOf(
    Libraries.composeUITooling,
)

internal val lifeCycleArchitectureDependencies = listOf(
    Libraries.lifeCycleViewModel,
    Libraries.lifeCycleRuntimeKtx,
)

internal val material3Dependencies = listOf(
    Libraries.material3,
)

internal val dataStoreDependencies = listOf(
    Libraries.datastore,
    Libraries.datastorePreference,
)

internal val networkingDependencies = listOf(
    Libraries.retrofit,
    Libraries.okHttpLoggingInterceptor,
    Libraries.gson,
    Libraries.okHttpGsonConverter,
)

internal val hiltDependencies = listOf(
    Libraries.hilt,
    Libraries.hiltWork,
    // Dependencies.hiltCompiler,
    // using later version of hilt doesn't require hiltLifecycleViewModel anymore
    // Dependencies.hiltLifecycleViewModel,
    Libraries.hiltNavigationCompose
)

internal val hiltKaptDependencies= listOf(
    Libraries.kaptHiltCompiler,
    Libraries.kaptHiltAndroidCompiler
)
