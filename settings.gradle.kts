@file:Suppress("UnstableApiUsage")

includeBuild("compositeBuild")
include(":demo")
include(":android-infrastructure-application")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
//        mavenLocal()
        google()
        mavenCentral()
        maven { url = uri("https://s01.oss.sonatype.org/content/repositories/releases/") }
    }
    versionCatalogs {
        create("libs") {
            from("io.github.daemon369:android-version-catalog:1.2.0")
        }
    }
}