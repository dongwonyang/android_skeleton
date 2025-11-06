pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "skeleton"
include(":app")
include(":core")
include(":feature")
include(":core:data")
include(":core:local")
include(":core:network")
include(":core:model")
include(":core:navigation")
include(":core:designsystem")
include(":feature:main")
include(":feature:auth")


includeBuild("build-logic") {
    name = "build-logic-included"
}

