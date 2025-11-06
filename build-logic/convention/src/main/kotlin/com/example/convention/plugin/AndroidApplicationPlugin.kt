package com.example.convention.plugin

import com.android.build.api.dsl.ApplicationExtension
import com.example.convention.configureComposeAndroid
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
            pluginManager.apply("com.android.application")

            setNamespace(path.replace(":", ".").removePrefix("."))

            val libs = extensions.libs

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                configureComposeAndroid(this)

                dependencies {
                    add("implementation", libs.findLibrary("timber").get())
                }
            }
        }
    }
}
