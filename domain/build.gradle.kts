plugins {
    kotlin()
    javaLibrary()
    kotlinKapt()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    addCommonDependencies()
}