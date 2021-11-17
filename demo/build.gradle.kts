plugins {
    id("com.android.application")
}

apply(from = "$rootDir/gradle/base.gradle")

android {
    defaultConfig {
        applicationId = "me.daemon.infrastructure.application.demo"
        versionCode = 1
        versionName = "1.0"
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
}

dependencies {
    implementation(libs.x.core.ktx)
    implementation(libs.x.appcompat)
    implementation(libs.x.constraintlayout)
    implementation(project(":android-infrastructure-application"))
}