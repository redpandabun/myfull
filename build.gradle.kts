plugins {
  alias(libs.plugins.kotlin)
  alias(libs.plugins.kotlin.spring)
  alias(libs.plugins.kotlinx.kover)

  alias(libs.plugins.spring.boot)
  alias(libs.plugins.spring.dependency.management)
}

dependencies {
  implementation(libs.bundles.api)
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

kover {
  reports {
    filters {
      excludes {
        classes("myfull.ApplicationKt") // exclude main method
      }
    }
    verify {
      rule {
        minBound(80)
      }
    }
  }
}

tasks {
  test {
    useJUnitPlatform()
  }
}