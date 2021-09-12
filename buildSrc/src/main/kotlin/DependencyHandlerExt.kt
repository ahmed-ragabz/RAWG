import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler


val lifeCycleList = listOf(
    Libs.Androidx.Lifecycle.viewModel,
    Libs.Androidx.Lifecycle.viewModelSavedState,
    Libs.Androidx.Lifecycle.commonJava8,
)

val ktxList = listOf(
    Libs.Androidx.Ktx.collection,
    Libs.Androidx.Ktx.core,
    Libs.Androidx.Ktx.activity,
    Libs.Androidx.Ktx.fragment,
)

val compilersList = listOf(
    Libs.Glide.compiler,
)

val uiList = listOf(
    Libs.Androidx.constraintLayout,
    Libs.material,
    Libs.Androidx.swipeRefreshLayout,
    Libs.Androidx.appCompat,
    Libs.Glide.glideCore
)

val androidTestList = listOf(
    Libs.AndroidTestLibs.junit,
    Libs.AndroidTestLibs.espresso
)

fun DependencyHandler.addCoreDependencies() {
    addCommonDependencies()
    uiList.forEach { implementation(it) }
    ktxList.forEach { implementation(it) }
    lifeCycleList.forEach { implementation(it) }
    compilersList.forEach { kapt(it) }
    addTestDependencies()
    addAndroidTestDependencies()
}

fun DependencyHandler.addTestDependencies() {
    testImplementation(Libs.TestLibs.junit)
}

fun DependencyHandler.addAndroidTestDependencies() =
    androidTestList.forEach { androidTestImplementation(it) }


fun DependencyHandler.addCommonDependencies() {
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlin.reflection)

    implementation(Libs.Coroutines.coroutinesCore)
    implementation(Libs.Coroutines.android)

    implementation(Libs.Hilt.android)
    kapt(Libs.Hilt.compiler)

    implementation(Libs.timber)
}



fun DependencyHandler.addDataDependencies() {
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.moshi)
    kapt(Libs.Retrofit.moshiCompiler)
    implementation(Libs.Retrofit.moshiKotlin)
    implementation(Libs.Retrofit.retrofitMoshiConverter)

    implementation(Libs.Okhttp.okhttpCore)
    implementation(Libs.Okhttp.loggingInterceptor)
    implementation(Libs.CommonInterceptors.ok2curl)
    debugImplementation(Libs.CommonInterceptors.Chucker.debug)

    implementation(Libs.Room.roomKtx)
    implementation(Libs.Room.runtime)
    kapt(Libs.Room.compiler)
}


/*
 * These extensions mimic the extensions that are generated on the fly by Gradle.
 * They are used here to provide above dependency syntax that mimics Gradle Kotlin DSL
 * syntax in module\build.gradle.kts.kts files.
 */
@Suppress("detekt.UnusedPrivateMember")
private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

@Suppress("detekt.UnusedPrivateMember")
private fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

@Suppress("detekt.UnusedPrivateMember")
private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

private fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

private fun DependencyHandler.testRuntimeOnly(dependencyNotation: Any): Dependency? =
    add("testRuntimeOnly", dependencyNotation)

private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)