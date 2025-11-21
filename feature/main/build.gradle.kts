plugins {
    alias(libs.plugins.example.feature)
}

dependencies {
    implementation(projects.feature.auth)
    implementation(projects.feature.home)
    implementation(projects.feature.detail)

    implementation(libs.kotlinx.immutable)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui.ktx)
}