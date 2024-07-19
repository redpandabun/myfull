plugins {
  alias(libs.plugins.kotlin)
}

dependencies {
  implementation(libs.bundles.api)
  testImplementation(libs.bundles.test)
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(libs.versions.java.get().toInt())
  }
}

kotlin {
  compilerOptions {}
}

tasks {
  test {
    useJUnitPlatform()
  }
}
