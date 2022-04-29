@file:Suppress("UNCHECKED_CAST")

import me.daemon.plugin.Configuration

plugins {
    id("com.android.library")
    id("maven-publish")
    id("signing")
}

ext {
    set("artifactId", "android-infrastructure-application")
    set("artifactVersion", "1.2.0")

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

android {
    buildFeatures {
        buildConfig = false
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    compileOnly(libs.x.core)
    implementation(libs.daemon.annotation)
}


afterEvaluate {
    publishing {

        publications {
            repositories {
                maven {
                    url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")

                    credentials {
                        username = rootProject.ext["ossrhUsername"]!!.toString()
                        password = rootProject.ext["ossrhPassword"]!!.toString()
                    }
                }
            }

            create<MavenPublication>("release") {
                groupId = Configuration.groupId
                artifactId = project.ext["artifactId"]!!.toString()
                version = project.ext["artifactVersion"]!!.toString()
                if (plugins.findPlugin("com.android.library") != null) {
                    from(components["release"])
                } else {
                    from(components["java"])
                }

                pom {
                    name.set((project.ext["pom"] as Map<String, *>)["name"]!!.toString())
                    description.set((project.ext["pom"] as Map<String, *>)["description"]!!.toString())
                    url.set((project.ext["pom"] as Map<String, *>)["url"]!!.toString())
                    licenses {
                        license {
                            name.set("The Apache Software License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            id.set("daemon")
                            name.set("Daemon")
                            email.set("daemon336699@gmail.com")
                        }
                    }
                    scm {
                        connection.set(((project.ext["pom"] as Map<String, *>)["scm"] as Map<String, String>)["connection"])
                        developerConnection.set(((project.ext["pom"] as Map<String, *>)["scm"] as Map<String, String>)["developerConnection"])
                        url.set(((project.ext["pom"] as Map<String, *>)["scm"] as Map<String, String>)["url"])
                    }
                }
            }
        }
    }

}

ext["signing.keyId"] = rootProject.ext["signing.keyId"]
ext["signing.password"] = rootProject.ext["signing.password"]
ext["signing.secretKeyRingFile"] = rootProject.ext["signing.secretKeyRingFile"]

signing {
    sign(publishing.publications)
}