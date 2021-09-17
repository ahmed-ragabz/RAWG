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

    buildTypes {
        getByName(configuration.BuildType.Debug) {
            isMinifyEnabled = configuration.DebugBuildType.isMinifyEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", configuration.DebugBuildType.baseUrl)
        }
        getByName(configuration.BuildType.Release) {
            isMinifyEnabled = configuration.ReleaseBuildType.isMinifyEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")

            buildConfigField("String", "BASE_URL", configuration.ReleaseBuildType.baseUrl)
        }
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

    /*modules*/
    api(project(Modules.domain))

    commonDependencies()
    androidTestDependencies()
    testDependencies()
    implementation(Libs.timber)

    /*libs*/
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

    room.forEach { implementation(it) }
    kapt(Libs.Room.compiler)

}