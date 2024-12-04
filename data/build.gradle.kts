plugins {
    alias(libs.plugins.ucb.jvm.library)
}

dependencies {
    implementation(project(":domain"))

    testImplementation(libs.junit.jupiter)
    testImplementation(libs.mockito)
    testImplementation(libs.test.coroutines)
}