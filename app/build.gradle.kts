import com.weather.app.build.configurations.AppConfigs
import com.weather.app.build.dependencies.addComposeDebugDependencies
import com.weather.app.build.dependencies.addComposeOfficialDependencies
import com.weather.app.build.dependencies.addDataStoreDependencies
import com.weather.app.build.dependencies.addLifeCycleArchitectureDependencies
import com.weather.app.build.dependencies.addMaterial3Dependencies
import com.weather.app.build.dependencies.addNetworkDependencies
import com.weather.app.build.dependencies.addCoreDependencies
import com.weather.app.build.dependencies.addHiltDependencies
import com.weather.app.build.dependencies.addWorkManagerDependencies

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

//pluginManager.withPlugin("kotlin-kapt") {
//    configure<org.jetbrains.kotlin.gradle.plugin.KaptExtension> {
//        useBuildCache = true
//    }
//}

android {
    namespace = com.weather.app.build.configurations.AppConfigs.application_id
    compileSdk = com.weather.app.build.configurations.AppConfigs.compileSdk

    defaultConfig {
        applicationId = com.weather.app.build.configurations.AppConfigs.application_id
        minSdk = com.weather.app.build.configurations.AppConfigs.minSdk
        targetSdk = com.weather.app.build.configurations.AppConfigs.compileSdk
        versionCode = com.weather.app.build.configurations.AppConfigs.versionCode
        versionName = com.weather.app.build.configurations.AppConfigs.versionName

        //testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        jvmTarget = com.weather.app.build.configurations.AppConfigs.jvmTarget
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
    implementation(project(mapOf("path" to ":features:weatherDetails")))
    implementation(project(mapOf("path" to ":features:homeScreen")))
  //implementation(project(mapOf("path" to ":features:login")))
    implementation(project(mapOf("path" to ":common:ui:theme")))
    //implementation(project(mapOf("path" to ":core:data:localsource:datastore")))
    implementation(project(mapOf("path" to ":core:data:remotesource:services")))
    implementation(project(mapOf("path" to ":features:homeScreen")))
    implementation(project(mapOf("path" to ":core:repository")))

//    implementation("com.google.android.material:material:1.11.0-beta01")
//    implementation("androidx.compose.material3:material3:1.2.0-alpha10")
//    implementation("androidx.compose.material3:material3-android:1.2.0-alpha10")
//    implementation("androidx.compose.material3:material3-window-size-class:1.2.0-alpha10")
//    implementation("androidx.compose.material:material:1.5.4")
//    implementation("androidx.compose.material:material-icons-core:1.5.4")
//    implementation("androidx.compose.material:material-icons-extended:1.5.4")



    //implementation("com.google.android.material:material:1.4.0")
    //implementation("androidx.compose.material:material:1.2.0")
    //implementation("androidx.compose.material3:material3:1.0.0-alpha16")

    //addKotlinDependencies()
    addCoreDependencies()
    addWorkManagerDependencies()
    addComposeOfficialDependencies()
    addComposeDebugDependencies()
    addLifeCycleArchitectureDependencies()
    addMaterial3Dependencies()
    addNetworkDependencies()
    addHiltDependencies()
    //addDataStoreDependencies()

//    implementation(Libraries.coreKtx)
//    implementation(Libraries.appCompat)
//    implementation(Libraries.composeUI)
//    implementation(Libraries.composeMaterial)
//    implementation(Libraries.composeUITooling)
//    implementation(Libraries.lifeCycleViewModel)
//    implementation(Libraries.lifeCycleRuntimeKtx)
//    implementation(Libraries.activityCompose)
//    implementation(Libraries.navigationCompose)
//    debugImplementation(Libraries.composeUITooling)


//    implementation("androidx.core:core-ktx:1.10.1")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
//    implementation("androidx.activity:activity-compose:1.6.1")
//    implementation("androidx.appcompat:appcompat:1.6.1")
//    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
//    implementation("androidx.compose.ui:ui")
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    implementation("androidx.compose.material3:material3")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")
}