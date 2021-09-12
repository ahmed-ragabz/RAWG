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
    addCommonDependencies()
    addDataDependencies()
    addAndroidTestDependencies()
    addTestDependencies()
}