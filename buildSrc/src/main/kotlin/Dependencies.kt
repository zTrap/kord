object Versions {
    const val kotlin = "1.3.61"
    const val kotlinxSerialization = "0.14.0"
    const val ktor = "1.3.1"
    const val kotlinxCoroutines = "1.3.3"
    const val kotlinLogging = "1.7.8"

    const val kotlinTest = kotlin
    const val junit5 = "5.6.0-M1"
    const val kotlinxCoroutinesTest = kotlinxCoroutines
    const val kotlinReflect = kotlin
    const val junitJupiterApi = junit5
    const val junitJupiterEngine = junit5
    const val sl4j = "1.7.29"
    const val bintray = "1.8.1"
}

@Suppress("ObjectPropertyName")
object Dependencies {
    const val jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val `kotlinx-serialization` = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.kotlinxSerialization}"
    const val `kotlinx-coroutines` = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutines}"

    const val `kotlin-logging` = "io.github.microutils:kotlin-logging:${Versions.kotlinLogging}"

    const val `kotlin-test` = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlinTest}"
    const val junit5 = "org.jetbrains.kotlin:kotlin-test-junit5:${Versions.kotlinTest}"
    const val `kotlinx-coroutines-test` = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinxCoroutinesTest}"
    const val `kotlin-reflect` = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinReflect}"
    const val `junit-jupiter-api` = "org.junit.jupiter:junit-jupiter-api:${Versions.junitJupiterApi}"
    const val `junit-jupiter-engine` = "org.junit.jupiter:junit-jupiter-engine:${Versions.junitJupiterEngine}"
    const val sl4j = "org.slf4j:slf4j-simple:${Versions.sl4j}"

    const val `ktor-client-json` =  "io.ktor:ktor-client-json:${Versions.ktor}"
    const val `ktor-client-json-jvm` = "io.ktor:ktor-client-json-jvm:${Versions.ktor}"
    const val `ktor-client-serialization-jvm` = "io.ktor:ktor-client-serialization-jvm:${Versions.ktor}"
    const val `ktor-client-cio` = "io.ktor:ktor-client-cio:${Versions.ktor}"
    const val `ktor-client-websocket` = "io.ktor:ktor-client-websockets:${Versions.ktor}"
    const val `ktor-client-mock` = "io.ktor:ktor-client-mock:${Versions.ktor}"
    const val `ktor-client-mock-jvm`= "io.ktor:ktor-client-mock-jvm:${Versions.ktor}"

    const val `cache-api` = "com.gitlab.kordlib.cache:api"
    const val `cache-map` = "com.gitlab.kordlib.cache:map"
}

object Plugins {
    const val kapt = "org.jetbrains.kotlin.kapt"
}