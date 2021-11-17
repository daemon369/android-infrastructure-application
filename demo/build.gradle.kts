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
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation(project(":android-infrastructure-application"))
}