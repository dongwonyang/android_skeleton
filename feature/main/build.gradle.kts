plugins {
    alias(libs.plugins.example.feature)
}

dependencies {
    implementation(projects.feature.home)
    implementation(projects.feature.auth)

    implementation(libs.kotlinx.immutable)
}