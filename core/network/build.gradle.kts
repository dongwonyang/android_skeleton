import java.util.Properties

plugins {
    alias(libs.plugins.example.core)
}

android {
    defaultConfig {
        buildConfigField(
            "String",
            "BASE_URL",
            "\"${getProperties("BASE_URL")}\""
        )
    }

    buildFeatures{
        buildConfig = true
    }
}

dependencies {
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)
}

fun getProperties(propertyKey: String): String {
    val properties = Properties()
    val file = rootProject.file("local.properties")

    if (file.exists()) {
        properties.load(file.inputStream())
    } else {
        println("⚠️ local.properties 파일을 찾을 수 없습니다.")
    }

    return properties.getProperty(propertyKey) ?: ""
}