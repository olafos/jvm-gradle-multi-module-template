import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.integration.test)
    alias(libs.plugins.test.logger)
    alias(libs.plugins.versions)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(26))
    }
}

ktlint {
    version = libs.versions.ktlint.ruleset
}

dependencies {
    testImplementation(libs.assertk)
    testImplementation(libs.mockk)
}

tasks {
    withType<Test>().configureEach {
        useJUnitPlatform()
    }
    withType<KotlinCompile>().configureEach {
        compilerOptions {
            freeCompilerArgs.add("-Xcontext-parameters")
            freeCompilerArgs.add("-Xcontext-sensitive-resolution")
            freeCompilerArgs.add("-Xnested-type-aliases")
        }
    }
}