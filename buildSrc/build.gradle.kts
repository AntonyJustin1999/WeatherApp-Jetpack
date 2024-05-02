import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}



//        plugins {
//            `kotlin-dsl`
//            `kotlin-dsl-precompiled-script-plugins`
//            kotlin("jvm") version "1.6.21"
//        }
//
////sourceSets {
////    main {
////        java {
////            setSrcDirs(listOf("src/main/kotlin"))
////        }
////    }
////}
//
//buildscript {
//
//    repositories {
//        mavenLocal()
//        mavenCentral()
//        google()
//    }
//
//    dependencies {
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
//        classpath ("org.jetbrains.kotlin:kotlin-script-runtime:1.4.10")
//    }
//}
//
//repositories {
//    mavenLocal()
//    mavenCentral()
//    google()
//}
//
//dependencies {
//    // in order to be able to use "kotlin-android" in the common script
//    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
//    // in order to recognize the "plugins" block in the common script
//    implementation("com.android.tools.build:gradle:7.2.0")
//    // in order to recognize the "android" block in the common script
//    implementation("com.android.tools.build:gradle-api:7.2.0")
//    implementation(kotlin("stdlib-jdk8"))
//    // in order to recognize DefaultActivityViewModelFactory by hilt
//    implementation("com.squareup:javapoet:1.13.0")
//}
////val compileKotlin: KotlinCompile by tasks
//
//
////compileKotlin.kotlinOptions {
////    jvmTarget = "1.8"
////}
////val compileTestKotlin: KotlinCompile by tasks
////compileTestKotlin.kotlinOptions {
////    jvmTarget = "1.8"
////}