package com.example.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.dependencies

fun Project.configureKotlinCoroutine() {
    val libs = extensions.libs

    dependencies {
        add("implementation", libs.findLibrary("kotlinx-coroutines-core").get())
        add("implementation", libs.findLibrary("kotlinx-coroutines-android").get())
    }
}
