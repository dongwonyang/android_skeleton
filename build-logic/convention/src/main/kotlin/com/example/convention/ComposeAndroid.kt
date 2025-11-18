package com.example.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

private val composeAndroidBundle: List<String> = listOf(
    "androidx-compose-bom",
    "androidx-ui",
    "androidx-material3",
    "androidx-ui-tooling",
    "androidx-ui-tooling-preview",
    "androidx-ui-test-junit4",
    "androidx-ui-test-manifest",
    "androidx-activity-compose"
)

// Application 모듈용
internal fun Project.configureComposeAndroid(ext: ApplicationExtension) {
    val libs = extensions.libs

    ext.buildFeatures.compose = true
    ext.composeOptions.kotlinCompilerExtensionVersion =
        libs.findVersion("composeCompiler").get().requiredVersion

    dependencies {
//        composeAndroidBundle.forEach { libName ->
//            val lib = libs.findLibrary(libName).get().get()
//            if (libName == "androidx-compose-bom") {
//                add("implementation", platform(lib))
//                add("androidTestImplementation", platform(lib))
//            } else {
//                add("implementation", lib)
//            }
//        }
    }
}

// Library 모듈용
internal fun Project.configureComposeAndroid(ext: LibraryExtension) {
    val libs = extensions.libs

    ext.buildFeatures.compose = true
    ext.composeOptions.kotlinCompilerExtensionVersion =
        libs.findVersion("composeCompiler").get().requiredVersion

    dependencies {
        composeAndroidBundle.forEach { libName ->
//            val lib = libs.findLibrary(libName).get().get()
//            if (libName == "androidx-compose-bom") {
//                add("implementation", platform(lib))
//                add("androidTestImplementation", platform(lib))
//            } else {
//                add("implementation", lib)
//            }
        }
    }
}
