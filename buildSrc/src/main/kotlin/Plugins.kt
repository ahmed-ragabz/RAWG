import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

fun PluginDependenciesSpec.androidApplication(): PluginDependencySpec =
    id("com.android.application")

fun PluginDependenciesSpec.androidLibrary(): PluginDependencySpec =
    id("com.android.library")

fun PluginDependenciesSpec.kotlinAndroid(): PluginDependencySpec =
    id("org.jetbrains.kotlin.android")

fun PluginDependenciesSpec.kotlinKapt(): PluginDependencySpec =
    kotlin("kapt")

fun PluginDependenciesSpec.kotlinParcelize(): PluginDependencySpec =
    id("kotlin-parcelize")

fun PluginDependenciesSpec.navigationSafeArgs(): PluginDependencySpec =
    id("androidx.navigation.safeargs.kotlin")

fun PluginDependenciesSpec.daggerHilt(): PluginDependencySpec =
    id("dagger.hilt.android.plugin")

fun PluginDependenciesSpec.javaLibrary(): PluginDependencySpec =
    id("java-library")

fun PluginDependenciesSpec.kotlin(): PluginDependencySpec =
    id("kotlin")


/* static analysis */
fun PluginDependenciesSpec.dependencyUpdates(): PluginDependencySpec =
    id("com.github.ben-manes.versions").version("0.39.0")

fun PluginDependenciesSpec.ktlint(includeVersion: Boolean = true): PluginDependencySpec =
    id("org.jlleitschuh.gradle.ktlint").also { if (includeVersion) it.version("10.2.0") }

fun PluginDependenciesSpec.detekt(includeVersion: Boolean = true): PluginDependencySpec =
    id("io.gitlab.arturbosch.detekt").also { if (includeVersion) it.version("1.18.1") }

fun PluginDependenciesSpec.spotless(includeVersion: Boolean = true): PluginDependencySpec =
    id("com.diffplug.spotless").also { if (includeVersion) it.version("5.14.3") }

fun PluginDependenciesSpec.spotBugs(includeVersion: Boolean = true): PluginDependencySpec =
    id("com.github.spotbugs").also { if (includeVersion) it.version("4.7.3") }