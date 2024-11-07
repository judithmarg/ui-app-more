plugins{
    alias(libs.plugins.ucb.android.library)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.framework"
}

dependencies{
    implementation(libs.retrofit)
    implementation(libs.bundles.networking)
    implementation(project(":domain"))
    implementation(project(":data"))
}