import com.weather.app.build.dependencies.addComposeDebugDependencies
import com.weather.app.build.dependencies.addComposeOfficialDependencies
import com.weather.app.build.dependencies.addHiltDependencies
import com.weather.app.build.dependencies.addLifeCycleArchitectureDependencies
import com.weather.app.build.dependencies.addMaterial3Dependencies
import com.weather.app.build.dependencies.addCoreDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    //id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.weather.app.features.homeScreen"
    compileSdk = 33

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = com.weather.app.build.configurations.AppConfigs.kotlinCompilerExtensionVersion
    }
}

dependencies {
    implementation(project(mapOf("path" to ":common:ui:navigation")))
    implementation(project(mapOf("path" to ":common:ui:components")))
    implementation(project(mapOf("path" to ":common:ui:propellericons")))
    implementation(project(mapOf("path" to ":common:model:domain")))
    implementation(project(mapOf("path" to ":core:repository")))
    addCoreDependencies()
    addComposeOfficialDependencies()
    addComposeDebugDependencies()
    addMaterial3Dependencies()
    addLifeCycleArchitectureDependencies()
    addHiltDependencies()
}