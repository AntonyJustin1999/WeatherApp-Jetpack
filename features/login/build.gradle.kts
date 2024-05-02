import com.weather.app.build.dependencies.addComposeDebugDependencies
import com.weather.app.build.dependencies.addComposeOfficialDependencies
import com.weather.app.build.dependencies.addDataStoreDependencies
import com.weather.app.build.dependencies.addLifeCycleArchitectureDependencies
import com.weather.app.build.dependencies.addMaterial3Dependencies
import com.weather.app.build.dependencies.addWorkManagerDependencies
import com.weather.app.build.dependencies.addHiltDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.weather.app.login.ui"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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
    implementation(project(mapOf("path" to ":common:ui:widgets")))
    implementation(project(mapOf("path" to ":common:ui:theme")))
    implementation(project(mapOf("path" to ":common:model:domain")))
    implementation(project(mapOf("path" to ":core:repository")))
    //implementation(project(mapOf("path" to ":core:data:localsource:datastore")))
    addWorkManagerDependencies()
    addComposeOfficialDependencies()
    addComposeDebugDependencies()
    addLifeCycleArchitectureDependencies()
    addMaterial3Dependencies()
    addHiltDependencies()
    addDataStoreDependencies()

}