plugins {
    alias(libs.plugins.ucb.jvm.library)
    alias(libs.plugins.kotlinSerialization)
}

dependencies{
    implementation(libs.kotlinx.serialization.json)
}