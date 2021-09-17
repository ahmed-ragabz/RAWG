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
    buildFeatures {
        viewBinding = true
        dataBinding = true
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
    testDependencies()
    androidTestDependencies()
    commonDependencies()

    uiList.forEach { implementation(it) }
    lifeCycleList.forEach { implementation(it) }



    api(project(Modules.core))
    api(project(Modules.data))
    api(project(Modules.domain))

    implementation(Libs.timber)
    implementation(Libs.Androidx.appStartup)
    implementation(Libs.Androidx.legacySupport)
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.gsonConverter)
    implementation(Libs.gson)
    kapt(Libs.Retrofit.moshiCodeGen)
    implementation(Libs.Retrofit.moshiKotlin)
    implementation(Libs.Retrofit.retrofitMoshiConverter)
    implementation(Libs.sandwich)

    implementation(Libs.Okhttp.okhttpCore)
    implementation(Libs.Okhttp.loggingInterceptor)
    implementation(Libs.CommonInterceptors.ok2curl)
    debugImplementation(Libs.CommonInterceptors.Chucker.debug)
    implementation(Libs.Paging.runtime)
    room.forEach{implementation(it)}
    kapt(Libs.Room.compiler)
    implementation(Libs.lottie)


}
