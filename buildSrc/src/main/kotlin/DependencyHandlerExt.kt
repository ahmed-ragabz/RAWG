import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project


val lifeCycleList = listOf(
    Libs.Androidx.Lifecycle.viewModel,
    Libs.Androidx.Lifecycle.viewModelSavedState,
    Libs.Androidx.Lifecycle.commonJava8,
    Libs.Androidx.Lifecycle.liveData,
    Libs.Androidx.Lifecycle.runtime,
    Libs.Androidx.Lifecycle.reactiveStreams,
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
    Libs.Androidx.coordinatorlayout,
    Libs.material,
    Libs.Androidx.swipeRefreshLayout,
    Libs.Androidx.appCompat,
    Libs.Glide.glideCore,
    Libs.Androidx.Ktx.activity,
    Libs.Androidx.Ktx.fragment,
    Libs.Androidx.Ktx.core,
    Libs.Navigation.fragmentKtx,
    Libs.Navigation.uiKtx,
    Libs.Navigation.runtimeKtx,
    Libs.Navigation.navigationCompose,
    Libs.Androidx.swipeRefreshLayout,
    Libs.loadMoreWrapper
)

val androidTestList = listOf(
    Libs.AndroidTestLibs.junit,
    Libs.AndroidTestLibs.espresso
)

val room = listOf(
    Libs.Room.roomKtx,
    Libs.Room.runtime,
)

fun DependencyHandler.coreDependencies() {
    commonDependencies()
    uiList.forEach { implementation(it) }
    ktxList.forEach { implementation(it) }
    lifeCycleList.forEach { implementation(it) }
    compilersList.forEach { kapt(it) }
    testDependencies()
    androidTestDependencies()
}

fun DependencyHandler.testDependencies() {
    testImplementation(Libs.TestLibs.junit)
}

fun DependencyHandler.androidTestDependencies() =
    androidTestList.forEach { androidTestImplementation(it) }


fun DependencyHandler.commonDependencies() {
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlin.reflection)

    implementation(Libs.Coroutines.coroutinesCore)
    implementation(Libs.Coroutines.android)

    implementation(Libs.Hilt.android)
    kapt(Libs.Hilt.compiler)

}


fun DependencyHandler.dataDependencies() {
    /*modules*/
    api(project(Modules.domain))

    /*libs*/
    api(Libs.Retrofit.retrofit)
    kapt(Libs.Retrofit.moshiCodeGen)
    api(Libs.Retrofit.moshiKotlin)
    api(Libs.Retrofit.retrofitMoshiConverter)
    api(Libs.sandwich)

    api(Libs.Okhttp.okhttpCore)
    api(Libs.Okhttp.loggingInterceptor)
    api(Libs.CommonInterceptors.ok2curl)
    debugImplementation(Libs.CommonInterceptors.Chucker.debug)

    api(Libs.Room.roomKtx)
    api(Libs.Room.runtime)
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