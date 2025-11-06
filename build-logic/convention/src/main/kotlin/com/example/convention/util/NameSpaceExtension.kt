package com.example.convention.util

import com.example.convention.androidExtension
import org.gradle.api.Project

fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "com.example.$name"
    }
}