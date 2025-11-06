package com.example.convention.plugin

import com.example.convention.libs
import com.example.convention.util.setNamespace
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

private val composeNavigationBundle = listOf("androidx-navigation-compose")
private val composeUiBundle = listOf(
    "androidx-ui",
    "androidx-ui-tooling",
    "androidx-ui-tooling-preview",
    "androidx-ui-graphics",
    "androidx-ui-graphics-android",
    "androidx-runtime-android"
)
private val composeMaterialBundle = listOf(
    "androidx-material3",
    "androidx-material3-android"
)

class FeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            setNamespace(path.replace(":", ".").removePrefix("."))

            val libs = extensions.libs

            dependencies {
                add("implementation", project(":core:local"))
                add("implementation", project(":core:designsystem"))
                add("implementation", project(":core:model"))
                add("implementation", project(":core:navigation"))
                add("implementation", project(":core:data"))

                // Hilt
                add("kapt", libs.findLibrary("hilt-compiler").get().get())
                add("implementation", libs.findLibrary("hilt-android").get().get())

                // Navigation
                composeNavigationBundle.forEach { libName ->
                    add("implementation", libs.findLibrary(libName).get().get())
                }

                // UI
                composeUiBundle.forEach { libName ->
                    add("implementation", libs.findLibrary(libName).get().get())
                }

                // Material3
                composeMaterialBundle.forEach { libName ->
                    add("implementation", libs.findLibrary(libName).get().get())
                }
            }

            pluginManager.apply("com.google.dagger.hilt.android")
        }
    }
}