plugins {
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
    id("org.jmailen.kotlinter") version "4.4.1"

    val kotlinVersion = "1.9.25"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    kotlin("kapt") version kotlinVersion
}

group = "com.yebali"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Postgresql
    runtimeOnly("org.postgresql:postgresql")

    // QueryDSL
    val querydslVersion = "5.0.0"
    implementation("com.querydsl:querydsl-jpa:$querydslVersion:jakarta")
    kapt("com.querydsl:querydsl-apt:$querydslVersion:jakarta")

    // Actuator
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Coroutine
    val coroutineVersion = "1.9.0"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutineVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${coroutineVersion}")

    /** Test **/
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.h2database:h2")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
