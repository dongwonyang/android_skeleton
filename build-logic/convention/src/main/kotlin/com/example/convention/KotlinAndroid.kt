package com.example.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// Application 모듈용
internal fun Project.configureKotlinAndroid(ext: ApplicationExtension) {
    configureBaseAndroid()

    val libs = extensions.libs

    dependencies {
        add("implementation", libs.findLibrary("androidx-core-ktx").get())
        add("implementation", libs.findLibrary("androidx-appcompat").get())
    }
}

// Library 모듈용
internal fun Project.configureKotlinAndroid(ext: LibraryExtension) {
    configureBaseAndroid()

    val libs = extensions.libs

    dependencies {
        add("implementation", libs.findLibrary("androidx-core-ktx").get())
    }
}


// 공통 속성
private fun Project.configureBaseAndroid(
    compileSdkVersion: Int = 34,
    minSdkVersion: Int = 24,
    targetSdkVersion: Int = 34,
    testRunner: String = "androidx.test.runner.AndroidJUnitRunner"
) {
    // Application
    (extensions.findByName("android") as? ApplicationExtension)?.apply {
        compileSdk = compileSdkVersion
        defaultConfig {
            minSdk = minSdkVersion
            targetSdk = targetSdkVersion
            testInstrumentationRunner = testRunner
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }

    // Library
    (extensions.findByName("android") as? LibraryExtension)?.apply {
        compileSdk = compileSdkVersion
        defaultConfig {
            minSdk = minSdkVersion
            testInstrumentationRunner = testRunner
            consumerProguardFiles("consumer-rules.pro")
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }

    // Kotlin JVM 옵션 설정
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }
}
