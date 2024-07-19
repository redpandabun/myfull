plugins {
  alias(libs.plugins.kotlin)
  alias(libs.plugins.kotlin.jpa)
  alias(libs.plugins.kotlin.spring)
  alias(libs.plugins.kotlinx.kover)
  alias(libs.plugins.spotless)
  alias(libs.plugins.spring.boot)
  alias(libs.plugins.spring.dependency.management)
}

dependencies {
  implementation(libs.bundles.api)
  runtimeOnly(libs.bundles.runtime)
  developmentOnly(libs.bundles.dev)
  testImplementation(libs.bundles.test)
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(libs.versions.java.get().toInt())
  }
}

kotlin {
  compilerOptions {
    freeCompilerArgs = properties["kotlin.compiler.free-args"]!!.toString().split(" ")
  }
}

allOpen {
  annotations(
    "jakarta.persistence.Entity",
    "jakarta.persistence.Embeddable",
    "jakarta.persistence.MappedSuperclass"
  )
}

kover {
  reports {
    filters {
      excludes {
        // exclude main method
        classes("myfull.ApplicationKt")
        annotatedBy("org.springframework.context.annotation.Configuration")
        annotatedBy("org.springframework.boot.autoconfigure.SpringBootApplication")
      }
    }
    verify {
      rule {
        minBound(80)
      }
    }
  }
}

spotless {
  kotlin {
    ktlint()
  }

  kotlinGradle {
    target("*.gradle.kts")
    ktlint()
  }
}

tasks {
  test {
    systemProperties["spring.profiles.active"] = "test"
    useJUnitPlatform()
  }
}
