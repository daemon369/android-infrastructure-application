plugins {
    id("com.android.library")
}

ext {
    set("artifactId", "android-infrastructure-application")
    set("artifactVersion", "1.0.0")

    set(
        "pom",
        mapOf(
            "name" to get("artifactId"),
            "description" to "Android infrastructure application",
            "url" to "https://github.com/daemon369/android-infrastructure-application",
            "scm" to mapOf(
                "connection" to "scm:git:git://github.com/daemon369/android-infrastructure-application.git",
                "developerConnection" to "scm:git:ssh://github.com/daemon369/android-infrastructure-application.git",
                "url" to "https://github.com/daemon369/android-infrastructure-application/tree/main",
            )
        )
    )
}

apply(from = "$rootDir/gradle/library_base.gradle")
apply(from = "$rootDir/gradle/maven-publish.gradle")

android {
    buildFeatures {
        buildConfig = false
    }
}

dependencies {
    compileOnly(libs.x.core)
    implementation(libs.daemon.annotation)
}