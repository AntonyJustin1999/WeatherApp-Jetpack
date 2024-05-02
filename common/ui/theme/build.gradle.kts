import com.weather.app.build.dependencies.addComposeDebugDependencies
import com.weather.app.build.dependencies.addComposeOfficialDependencies
import com.weather.app.build.dependencies.addLifeCycleArchitectureDependencies
import com.weather.app.build.dependencies.addMaterial3Dependencies
import com.weather.app.build.dependencies.addCoreDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.weather.app.common.ui.theme"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = com.weather.app.build.configurations.AppConfigs.kotlinCompilerExtensionVersion
    }
}

dependencies {

//    implementation ("com.google.android.material:material:1.9.0")
//    implementation ("androidx.compose.material3:material3:1.1.0")

//    implementation("com.google.android.material:material:1.11.0-beta01")
//    implementation("androidx.compose.material3:material3:1.2.0-alpha10")
//    implementation("androidx.compose.material3:material3-android:1.2.0-alpha10")
//    implementation("androidx.compose.material3:material3-window-size-class:1.2.0-alpha10")
//    implementation("androidx.compose.material:material:1.5.4")
    //implementation("androidx.compose.material:material-icons-core:1.5.4")
    //implementation("androidx.compose.material:material-icons-extended:1.5.4")

    addCoreDependencies()
    addComposeOfficialDependencies()
    addComposeDebugDependencies()
    addLifeCycleArchitectureDependencies()
    addMaterial3Dependencies()

}