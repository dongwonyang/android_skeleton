package com.example.convention.plugin

import com.android.build.gradle.LibraryExtension
import com.example.convention.configureKotlinAndroid
import com.example.convention.libs
import com.example.convention.util.setNamespace
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies


class CorePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            setNamespace(path.replace(":", ".").removePrefix("."))

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
            }

            val libs = extensions.libs

            dependencies{
                // Hilt
                add("kapt", libs.findLibrary("hilt-compiler").get().get())
                add("implementation", libs.findLibrary("hilt-android").get().get())
            }

            pluginManager.apply("com.google.dagger.hilt.android")
        }
    }
}
