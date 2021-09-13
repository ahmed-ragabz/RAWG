plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinKapt()
}
android {
    compileSdk = ProjectConfiguration.COMPILE_SDK
    defaultConfig {
        minSdk = ProjectConfiguration.MIN_SDK
        targetSdk = ProjectConfiguration.TARGET_SDK
    }
}

dependencies {
    api(project(Modules.core))
    api(project(Modules.models))
    commonDependencies()
    implementation(Libs.timber)
}