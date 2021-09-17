plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinKapt()
    daggerHilt()
}
android {
    compileSdk = ProjectConfiguration.COMPILE_SDK
    defaultConfig {
        minSdk = ProjectConfiguration.MIN_SDK
        targetSdk = ProjectConfiguration.TARGET_SDK
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    api(project(Modules.core))
    api(project(Modules.models))
    commonDependencies()
    implementation(Libs.timber)
}