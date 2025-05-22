plugins {
    kotlin("jvm") version "1.9.23"
    application
}

group = "seg3x02"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.platform:junit-platform-suite:1.12.2")
    testImplementation("io.cucumber:cucumber-java8:7.21.1")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.21.1")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("cucumber.junit-platform.naming-strategy", "long")
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("MainKt")
}
