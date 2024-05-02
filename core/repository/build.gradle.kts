import com.weather.app.build.dependencies.addComposeDebugDependencies
import com.weather.app.build.dependencies.addComposeOfficialDependencies
import com.weather.app.build.dependencies.addDataStoreDependencies
import com.weather.app.build.dependencies.addLifeCycleArchitectureDependencies
import com.weather.app.build.dependencies.addMaterial3Dependencies
import com.weather.app.build.dependencies.addCoreDependencies
import com.weather.app.build.dependencies.addHiltDependencies
import com.weather.app.build.dependencies.addNetworkDependencies
import com.weather.app.build.dependencies.addWorkManagerDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    //id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.weather.app.core.repository"
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

    implementation(project(mapOf("path" to ":common:model:domain")))
  //implementation(project(mapOf("path" to ":core:data:localsource:datastore")))
    implementation(project(mapOf("path" to ":core:mappers")))
    implementation(project(mapOf("path" to ":core:data:remotesource:services")))
    //implementation(project(mapOf("path" to ":app")))

    //addKotlinDependencies()
    addCoreDependencies()
    addWorkManagerDependencies()
    addComposeOfficialDependencies()
    addComposeDebugDependencies()
    addLifeCycleArchitectureDependencies()
    addMaterial3Dependencies()
    addDataStoreDependencies()
    addHiltDependencies()
    addNetworkDependencies()


}