import com.weather.app.build.dependencies.addComposeDebugDependencies
import com.weather.app.build.dependencies.addComposeOfficialDependencies
import com.weather.app.build.dependencies.addLifeCycleArchitectureDependencies
import com.weather.app.build.dependencies.addNetworkDependencies
import com.weather.app.build.dependencies.addCoreDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.weather.app.data.remotesource.services"
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

    addCoreDependencies()
    addComposeOfficialDependencies()
    addComposeDebugDependencies()
    addLifeCycleArchitectureDependencies()
    addNetworkDependencies()

}