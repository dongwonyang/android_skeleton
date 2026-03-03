plugins {
    alias(libs.plugins.example.core)
}


dependencies {
    implementation(projects.core.data)
    implementation(projects.core.model)
}
