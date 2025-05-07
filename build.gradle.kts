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
    mainClass.set("org.example.currencyconverter.MainApp")  // Updated main class
}

javafx {
    version = "17"
    modules = listOf("javafx.controls")  // Only 'controls' needed (no FXML)
}

tasks.test {
    useJUnitPlatform()
}