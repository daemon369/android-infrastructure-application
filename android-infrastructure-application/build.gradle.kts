@file:Suppress("UNCHECKED_CAST")

import me.daemon.gradle.PublishInfo
import me.daemon.gradle.PublishInfo.Pom
import me.daemon.gradle.PublishInfo.Pom.Scm

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")
    id("signing")
    id("me.daemon.gradle")
}

val artifactGroupId: String by project
val ossrhUsername: String by project.extra
val ossrhPassword: String by project.extra

val publishInfo = PublishInfo(
    artifactId = "android-infrastructure-application",
    artifactVersion = "1.3.0",
    pom = Pom(
        name = "android-infrastructure-application",
        description = "Android infrastructure application",
        url = "https://github.com/daemon369/android-infrastructure-application",
        scm = Scm(
            connection = "scm:git:git://github.com/daemon369/android-infrastructure-application.git",
            developerConnection = "scm:git:ssh://github.com/daemon369/android-infrastructure-application.git",
            url = "https://github.com/daemon369/android-infrastructure-application/tree/main",
        )
    )
)

apply(from = "$rootDir/gradle/base.gradle")

android {
    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        kotlinOptions.freeCompilerArgs =
            listOf("-module-name", "${artifactGroupId}.${publishInfo.artifactId}")
    }

    buildFeatures {
        buildConfig = false
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
        multipleVariants {
            withSourcesJar()
            withJavadocJar()
            allVariants()
        }
    }
}

dependencies {
    compileOnly(libs.x.core)
//    implementation(libs.daemon.annotation)
    implementation("io.github.daemon369:annotation:1.0.0")
}


afterEvaluate {
    publishing {

        publications {
            repositories {
                maven {
                    url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")

                    credentials {
                        username = ossrhUsername
                        password = ossrhPassword
                    }
                }
            }

            create<MavenPublication>("release") {
                groupId = artifactGroupId
                artifactId = publishInfo.artifactId
                version = publishInfo.artifactVersion
                if (plugins.findPlugin("com.android.library") != null) {
                    from(components["release"])
                } else {
                    from(components["java"])
                }

                pom {
                    name.set(publishInfo.pom.name)
                    description.set(publishInfo.pom.description)
                    url.set(publishInfo.pom.url)
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
                        connection.set(publishInfo.pom.scm.connection)
                        developerConnection.set(publishInfo.pom.scm.developerConnection)
                        url.set(publishInfo.pom.scm.url)
                    }
                }
            }
        }
    }

}

signing {
    sign(publishing.publications)
}