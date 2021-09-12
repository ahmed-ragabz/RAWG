// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    dependencyUpdates()
    ktlint()
    detekt()
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Libs.Kotlin.version}")
        classpath("androidx.benchmark:benchmark-gradle-plugin:${Libs.Androidx.Benchmark.version}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Libs.Navigation.version}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Libs.Hilt.version}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    sourceCompatibility = JavaVersion.VERSION_1_8.toString()
    targetCompatibility = JavaVersion.VERSION_1_8.toString()

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}
