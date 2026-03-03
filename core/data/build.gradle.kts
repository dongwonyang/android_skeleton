plugins {
    alias(libs.plugins.example.core)
}

dependencies {
    implementation(projects.core.network)
    implementation(projects.core.domain)
}