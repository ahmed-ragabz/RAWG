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

    buildTypes {
        getByName(configuration.BuildType.Debug){
            isMinifyEnabled = configuration.DebugBuildType.isMinifyEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            buildConfigField("String","BASE_URL", configuration.DebugBuildType.baseUrl)
        }
        getByName(configuration.BuildType.Release){
            isMinifyEnabled = configuration.ReleaseBuildType.isMinifyEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")

            buildConfigField("String","BASE_URL", configuration.ReleaseBuildType.baseUrl)
        }
    }
}

dependencies {
    commonDependencies()
    dataDependencies()
    androidTestDependencies()
    testDependencies()
    implementation(Libs.timber)
    implementation(Libs.whatIf)
}