package com.weather.app.build.configurations

import com.weather.app.build.dependencies.Versions

object AppConfigs {
    const val application_id = "com.weather.app"
    const val compileSdk = 33
    const val minSdk = 28
    const val versionCode = 1
    const val versionName = "1.0"
    const val jvmTarget = "17"
    const val kotlinCompilerExtensionVersion = Versions.compose_version
}