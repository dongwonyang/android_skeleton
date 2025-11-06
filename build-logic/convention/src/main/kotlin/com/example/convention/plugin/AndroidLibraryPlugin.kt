package com.example.convention.plugin

import com.android.build.gradle.LibraryExtension
import com.example.convention.configureKotlinAndroid
import com.example.convention.configureKotlinCoroutine
import com.example.convention.libs
import com.example.convention.util.setNamespace
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")

            setNamespace(path.replace(":", ".").removePrefix("."))

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
            }

            configureKotlinCoroutine()

            val libs = extensions.libs

            dependencies {
                add("implementation", libs.findLibrary("timber").get())
            }
        }
    }
}
