plugins {
    id("kotlin-convention")
}

group = "pl.codeplay.jvm-gradle-multi-module-template"
version = providers.gradleProperty("version").map { it.removePrefix("v") }.getOrElse("0.1.0-SNAPSHOT")
