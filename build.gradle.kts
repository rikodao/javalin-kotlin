plugins {
    kotlin("jvm") version "1.3.60"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
//    google()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.javalin:javalin:3.7.0")
    implementation("org.slf4j:slf4j-simple:1.7.28")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.0")
//    api("com.google.dagger:dagger:2.x")
//    annotationProcessor("com.google.dagger:dagger-compiler:2.x")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}