import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
val allureVersion = "2.24.0"
// Define the version of AspectJ
val aspectJVersion = "1.9.20.1"

// Define configuration for AspectJ agent
val agent: Configuration by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = true
}

plugins {
    kotlin("jvm") version "1.9.0"
    id("net.serenity-bdd.serenity-gradle-plugin") version "4.0.15"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.serenity-bdd:serenity-core:4.0.30")
    testImplementation("net.serenity-bdd:serenity-junit:4.0.30")
    testImplementation("net.serenity-bdd:serenity-junit5:4.0.30")


    testImplementation("org.jetbrains.kotlin:kotlin-test:1.8.10")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")
    //allure
    implementation("com.github.invictum:serenity-allure-integration:1.0.0")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}

kotlin {
    jvmToolchain(19)
}