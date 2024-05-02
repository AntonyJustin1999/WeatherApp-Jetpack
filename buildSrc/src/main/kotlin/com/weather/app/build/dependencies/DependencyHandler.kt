package com.weather.app.build.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler

//fun DependencyHandler.addKotlinDependencies() {
//    kotlinDependencies.forEach {
//        add("implementation", it)
//    }
//}
fun DependencyHandler.addCoreDependencies(){
    coreDependencies.forEach{
        add("implementation", it)
    }
}

fun DependencyHandler.addComposeOfficialDependencies(){
    composeOfficialDependencies.forEach{
        add("implementation", it)
    }
}

fun DependencyHandler.addWorkManagerDependencies(){
    workManagerDependencies.forEach{
        add("implementation", it)
    }
}

fun DependencyHandler.addComposeDebugDependencies() {
    composeUIToolingDependencies.forEach {
        add("debugImplementation", it)
    }
}

fun DependencyHandler.addLifeCycleArchitectureDependencies(){
    lifeCycleArchitectureDependencies.forEach{
        add("implementation", it)
    }
}

fun DependencyHandler.addMaterial3Dependencies(){
    material3Dependencies.forEach{
        add("implementation", it)
    }
}

fun DependencyHandler.addDataStoreDependencies(){
    dataStoreDependencies.forEach{
        add("implementation", it)
    }
}

fun DependencyHandler.addNetworkDependencies(){
    networkingDependencies.forEach{
        add("implementation", it)
    }
}

fun DependencyHandler.addHiltDependencies() {
    hiltDependencies.forEach {
        add("implementation", it)
    }
    hiltKaptDependencies.forEach{
        add("kapt", it)
    }
}