plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinKapt()
    daggerHilt()
    kotlinParcelize()
}
android {
    compileSdk = ProjectConfiguration.COMPILE_SDK
    defaultConfig {
        minSdk = ProjectConfiguration.MIN_SDK
        targetSdk = ProjectConfiguration.TARGET_SDK
    }
    with(JavaVersion.VERSION_1_8) {
        val javaVersion = this
        compileOptions {
            sourceCompatibility = javaVersion
            targetCompatibility = javaVersion
        }
        kotlinOptions {
            jvmTarget = javaVersion.toString()
        }
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}
dependencies {
    addCoreDependencies()
}

