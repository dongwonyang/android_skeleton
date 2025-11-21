package com.example.convention.plugin

import com.android.build.api.dsl.ApplicationExtension
import com.example.convention.configureKotlinAndroid
import com.example.convention.libs
import com.example.convention.util.setNamespace
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
            }

            setNamespace(path.replace(":", ".").removePrefix("."))

            val libs = extensions.libs

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
            }

            dependencies{
                add("kapt", libs.findLibrary("hilt-compiler").get().get())
                add("implementation", libs.findLibrary("hilt-android").get().get())
            }

            pluginManager.apply("com.google.dagger.hilt.android")
        }
    }
}
