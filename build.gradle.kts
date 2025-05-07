plugins {
    java
    application
    id("org.openjfx.javafxplugin") version "0.0.13"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    mainClass.set("org.example.currencyconverterfinalprojectsdev200carsonbeckmann.MainApp")
}

javafx {
    version = "17"
    modules = listOf("javafx.controls")
}

tasks.test {
    useJUnitPlatform()
}