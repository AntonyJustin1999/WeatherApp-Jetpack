pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "WeatherApp"
include(":app")
include(":features")
include(":common:ui:navigation")
include(":common:ui:theme")
include(":common:model:domain")
include(":common:ui:components")
include(":common:ui:widgets")
include(":common:ui:propellericons")
include(":core:repository")
include(":core:mappers")
include(":core:data:remotesource:services")
include(":features:weatherDetails")
//include(":features:weatherHome")
include(":features:homeScreen")
