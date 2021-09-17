plugins {
    kotlin()
    javaLibrary()
    kotlinKapt()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
dependencies {
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlin.reflection)

    implementation(Libs.Retrofit.moshiKotlin)
    kapt(Libs.Retrofit.moshiCodeGen)

    implementation(Libs.gson)
}