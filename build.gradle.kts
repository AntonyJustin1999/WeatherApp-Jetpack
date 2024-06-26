import com.weather.app.build.dependencies.Versions

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")   //1.7.0
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.42")
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}