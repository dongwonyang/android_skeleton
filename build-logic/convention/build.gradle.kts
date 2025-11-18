plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp)
    compileOnly(libs.compose.compiler)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        languageVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_1_9)
        apiVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_1_9)
    }
}
gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "example.android.application"
            implementationClass = "com.example.convention.plugin.AndroidApplicationPlugin"
        }

        register("androidLibrary") {
            id = "example.android.library"
            implementationClass = "com.example.convention.plugin.AndroidLibraryPlugin"
        }

        register("feature") {
            id = "example.feature"
            implementationClass = "com.example.convention.plugin.FeaturePlugin"
        }

        register("core") {
            id = "example.core"
            implementationClass = "com.example.convention.plugin.CorePlugin"
        }
    }
}