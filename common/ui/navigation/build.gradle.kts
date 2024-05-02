import com.weather.app.build.dependencies.addComposeDebugDependencies
import com.weather.app.build.dependencies.addComposeOfficialDependencies
import com.weather.app.build.dependencies.addLifeCycleArchitectureDependencies
import com.weather.app.build.dependencies.addCoreDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.weather.app.common.ui.navigation"
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
//    implementation("androidx.core:core-ktx:1.9.0")
//    implementation("androidx.appcompat:appcompat:1.6.1")
//    implementation("com.google.android.material:material:1.11.0")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    addCoreDependencies()
    addComposeOfficialDependencies()
    addComposeDebugDependencies()
    addLifeCycleArchitectureDependencies()

}