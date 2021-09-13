import configuration.BuildType
import configuration.DebugBuildType
import configuration.ReleaseBuildType

plugins {
    androidApplication()
    kotlinAndroid()
    kotlinKapt()
    kotlinParcelize()
    navigationSafeArgs()
    daggerHilt()
}

android {
    compileSdk = ProjectConfiguration.COMPILE_SDK
    defaultConfig {
        applicationId = ProjectConfiguration.APPLICATION_ID
        minSdk = ProjectConfiguration.MIN_SDK
        targetSdk = ProjectConfiguration.TARGET_SDK
        versionCode = ProjectConfiguration.VERSION_CODE
        versionName = ProjectConfiguration.VERSION_NAME
        testInstrumentationRunner = ProjectConfiguration.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName(BuildType.Release) {
            isMinifyEnabled = ReleaseBuildType.isMinifyEnabled
            isTestCoverageEnabled = ReleaseBuildType.isTestCoverageEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }

        getByName(BuildType.Debug) {
            isMinifyEnabled = DebugBuildType.isMinifyEnabled
            isTestCoverageEnabled = DebugBuildType.isTestCoverageEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")

            applicationIdSuffix = DebugBuildType.applicationIdSuffix
            versionNameSuffix = DebugBuildType.versionNameSuffix
        }
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
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    appDependencies()
    implementation(Libs.timber)
    implementation(Libs.whatIf)

}
