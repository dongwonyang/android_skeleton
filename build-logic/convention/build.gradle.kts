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