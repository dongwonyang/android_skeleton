package com.example.convention.plugin

import com.android.build.gradle.LibraryExtension
import com.example.convention.configureKotlinAndroid
import com.example.convention.libs
import com.example.convention.util.setNamespace
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

private val composeNavigationBundle = listOf(
    "androidx-navigation-compose",
    "hilt-navigation-compose"
)

private val composeUiBundle = listOf(
    "androidx-ui",
    "androidx-ui-tooling",
    "androidx-ui-tooling-preview",
    "androidx-ui-graphics",
    "androidx-ui-graphics-android",
    "androidx-runtime-android"
)
private val composeMaterialBundle = listOf(
    "androidx-material3-android"
)

private val xmlUiBundle = listOf(
    "androidx-appcompat",
    "androidx-core-ktx",
    "androidx-fragment-ktx",
    "material"
)


class FeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
                apply("org.jetbrains.kotlin.plugin.compose")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            setNamespace(path.replace(":", ".").removePrefix("."))

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)

                buildFeatures {
                    viewBinding = true
                }
            }

                val libs = extensions.libs

            dependencies {
                add("implementation", project(":core:designsystem"))
                add("implementation", project(":core:model"))
                add("implementation", project(":core:data"))
                add("implementation", project(":core:navigation"))

                // Hilt
                add("kapt", libs.findLibrary("hilt-compiler").get().get())
                add("implementation", libs.findLibrary("hilt-android").get().get())

                // Navigation
                composeNavigationBundle.forEach { libName ->
                    add("implementation", libs.findLibrary(libName).get().get())
                }

                // Compose UI
                composeUiBundle.forEach { libName ->
                    add("implementation", libs.findLibrary(libName).get().get())
                }

                // Material3
                composeMaterialBundle.forEach { libName ->
                    add("implementation", libs.findLibrary(libName).get().get())
                }

                // XML UI
                xmlUiBundle.forEach { libName ->
                    add("implementation", libs.findLibrary(libName).get().get())
                }

                add("implementation",libs.findLibrary("kotlinx-serialization-json").get().get())
            }

            pluginManager.apply("com.google.dagger.hilt.android")
        }
    }
}