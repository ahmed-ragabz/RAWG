object Libs {

    // region Kotlin
    object Kotlin {
        const val version = "1.5.30"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val reflection = "org.jetbrains.kotlin:kotlin-reflect:$version"
    }
    // endregion

    // region Androidx
    object Androidx {
        const val appCompat = "androidx.appcompat:appcompat:1.4.0-alpha03"
        const val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.0"
        const val coordinatorlayout = "androidx.coordinatorlayout:coordinatorlayout:1.1.0"
        const val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"
        const val swipeRefreshLayout =
            "androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01"
        const val slidingPaneLayout =
            "androidx.slidingpanelayout:slidingpanelayout:1.2.0-alpha01"

        // fragment test
        const val fragmentTest = "androidx.fragment:fragment-testing:1.4.0-alpha08"

        // drawer layout
        const val drawerLayout = "androidx.drawerlayout:drawerlayout:1.1.0-rc01"

        // card view
        const val cardview = "androidx.cardview:cardview:1.0.0"

        // browser
        const val browser = "androidx.browser:browser:$1.0.0"

        // app startup
        const val appStartup = "androidx.startup:startup-runtime:1.1.0"

        const val recyclerview = "androidx.recyclerview:recyclerview:1.2.1"
        const val recyclerviewSelection = "androidx.recyclerview:recyclerview-selection:1.1.0"

        // region Benchmark
        object Benchmark {
            const val version = "1.1.0-alpha07"
            const val benchmarkJunit = "androidx.benchmark:benchmark-junit4:$version"
            const val macro =
                "androidx.benchmark:benchmark-macro-junit4:$version"
        }
        // endregion

        // region ktx
        object Datastore {
            private const val version = "1.0.0"
            const val core = "androidx.datastore:datastore:$version"
            const val prederences = "androidx.datastore:datastore-preferences:$version"
        }
        // endregion

        // region Ktx
        object Ktx {
            private const val coreKtxVersion = "1.7.0-alpha02"
            private const val fragmentKtxVersion = "1.4.0-alpha08"
            private const val collectionKtxVersion = "1.2.0-alpha01"
            private const val activityKtxVersion = "1.4.0-alpha01"

            const val core = "androidx.core:core-ktx:$coreKtxVersion"
            const val fragment = "androidx.fragment:fragment-ktx:$fragmentKtxVersion"
            const val collection = "androidx.collection:collection-ktx:$collectionKtxVersion"
            const val activity = "androidx.activity:activity-ktx:$activityKtxVersion"
        }
        // endregion

        // region Lifecycle
        object Lifecycle {
            private const val version = "2.4.0-alpha03"

            const val compiler = "androidx.lifecycle:lifecycle-compiler:$version"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModelSavedState =
                "androidx.lifecycle:lifecycle-viewmodel-savedstate:$version"

            // alternately - if using Java8, use the following instead of lifecycle-compiler
            const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$version"

            // optional - helpers for implementing LifecycleOwner in a Service
            const val serviceHelper = "androidx.lifecycle:lifecycle-service:$version"

            // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
            const val process = "androidx.lifecycle:lifecycle-process:$version"

            // optional - ReactiveStreams support for LiveData
            const val reactiveStreams = "androidx.lifecycle:lifecycle-reactivestreams-ktx:$version"


        }
        // endregion
    }
    // endregion

    // region paging
    object Paging {
        private const val version = "3.0.1"
        const val runtime =
            "androidx.paging:paging-runtime:$version"
        const val rxJava2 =
            "androidx.paging:paging-rxjava2:$version"
        const val rxJava3 =
            "androidx.paging:paging-rxjava3:$version"
    }
    //endregion

    //region Okhttp
    object Okhttp {
        private const val version = "5.0.0-alpha.2"

        const val okhttpCore = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }
    // endregion

    object CommonInterceptors {
        private const val ok2CurlVersion = "0.7.0"
        const val ok2curl = "com.github.mrmike:ok2curl:$ok2CurlVersion"

        object Chucker {
            const val debug = "com.github.chuckerteam.chucker:library:3.5.2"
            const val release = "com.github.chuckerteam.chucker:library-no-op:3.5.2"
        }
    }

    // region Retrofit
    object Retrofit {
        private const val retrofitVersion = "2.9.0"
        private const val moshiVersion = "1.12.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"

//        const val moshi = "com.squareup.moshi:moshi:$moshiVersion"
        const val moshiCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:$moshiVersion"
        const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    }
    //endregion

    // region Glide
    object Glide {
        private const val version = "4.12.0"
        const val glideCore = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }
    // endregion

    // region Coroutines
    object Coroutines {
        // coroutines
        private const val version = "1.4.2"

        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }
    // endregion

    // region Navigation
    object Navigation {
        const val version = "2.4.0-alpha08"

        // fragment ktx
        const val runtimeKtx =
            "androidx.navigation:navigation-runtime-ktx:$version"
        // fragment ktx
        const val fragmentKtx =
            "androidx.navigation:navigation-fragment-ktx:$version"

        // ui ktx
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"

        // Feature module Support
        const val dynamicFeatureFragment =
            "androidx.navigation:navigation-dynamic-features-fragment:$version"

        // Testing Navigation
        const val navigationTesting = "androidx.navigation:navigation-testing:$version"

        // Jetpack Compose Integration
        const val navigationCompose = "androidx.navigation:navigation-compose:2.4.0-alpha08"
    }
    // endregion

    // region Room
    object Room {
        private const val version = "2.2.5"

        const val compiler = "androidx.room:room-compiler:$version"
        const val roomKtx = "androidx.room:room-ktx:$version"
        const val runtime = "androidx.room:room-runtime:$version"
    }
    // endregion

    // region Hilt
    object Hilt {
        const val version = "2.38.1"

        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
    }
    // endregion

    // region Firebase
    object Firebase {
        const val analytics =
            "com.google.firebase:firebase-analytics-ktx:17.4.0"

        const val auth = "com.google.firebase:firebase-auth-ktx:19.3.1"

        const val config =
            "com.google.firebase:firebase-config-ktx:19.1.4"

//        const val firestore =
//            "com.google.firebase:firebase-firestore-ktx:${Versions.lifecycle}"
//
//        const val functions =
//            "com.google.firebase:firebase-functions-ktx:${Versions.lifecycle}"
//
//        const val messaging =
//            "com.google.firebase:firebase-messaging:${Versions.lifecycle}"
//
//        const val uiAuth = "com.firebaseui:firebase-ui-auth:${Versions.lifecycle}"
//
//        const val crashlytics =
//            "com.google.firebase:firebase-crashlytics:${Versions.lifecycle}"
    }
    // endregion

    // region Test Libs
    object TestLibs {
        const val junit = "junit:junit:4.13.2"
    }
    // endregion

    // region Android Test Libs
    object AndroidTestLibs {
        const val junit = "androidx.test.ext:junit:1.1.4-alpha01"
        const val espresso = "androidx.test.espresso:espresso-core:3.5.0-alpha01"
    }
    // endregion

    //region General Libs
    const val material = "com.google.android.material:material:1.5.0-alpha03"
    const val timber = "com.jakewharton.timber:timber:5.0.1"

    // okio
    const val okio = "com.squareup.okio:okio:1.14.0"

    // lottie
    const val lottie = "com.airbnb.android:lottie:3.0.0"
    const val gson = "com.google.code.gson:gson:2.8.6"
    const val hamcrest = "org.hamcrest:hamcrest-library:1.3"
    //endregion

    const val localization = "com.akexorcist:localization:1.2.2"

    const val whatIf = "com.github.skydoves:whatif:1.1.0"

    const val sandwich = "com.github.skydoves:sandwich:1.2.1"
    const val loadMoreWrapper = "com.github.nukc:LoadMoreWrapper:v1.9.1"
}

