import com.weather.app.build.dependencies.addComposeDebugDependencies
import com.weather.app.build.dependencies.addComposeOfficialDependencies
import com.weather.app.build.dependencies.addDataStoreDependencies
import com.weather.app.build.dependencies.addHiltDependencies
import com.weather.app.build.dependencies.addLifeCycleArchitectureDependencies
import com.weather.app.build.dependencies.addMaterial3Dependencies
import com.weather.app.build.dependencies.addWorkManagerDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ( "kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.weather.app.core.data.localsource.datastore"
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
}

dependencies {

    addWorkManagerDependencies()
    addComposeOfficialDependencies()
    addComposeDebugDependencies()
    addLifeCycleArchitectureDependencies()
    addMaterial3Dependencies()
    addDataStoreDependencies()
    addHiltDependencies()

}