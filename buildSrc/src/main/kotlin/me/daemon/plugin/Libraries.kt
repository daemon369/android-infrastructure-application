package me.daemon.plugin

object Libraries {

    /**
     * versions
     */
    @Suppress("ClassName")
    private object v {
        const val kotlin = "1.5.21"
        const val coroutines = "1.5.1"

        const val annotation = "1.2.0"
        const val core = "1.6.0"
        const val appCompat = "1.3.1"
        const val lifecycle = "2.3.1"
        const val activity = "1.3.1"
        const val fragment = "1.3.6"
        const val navigation = "2.3.5"
        const val constraintLayout = "2.1.0"

        const val junit = "4.13.2"
        const val xJunit = "1.1.2"
        const val espresso = "3.3.0"
    }

    /**
     * AndroidX libraries
     */
    object X {
        const val annotation = "androidx.annotation:annotation:${v.annotation}"
        const val coreKtx = "androidx.core:core-ktx:${v.core}"
        const val appCompat = "androidx.appcompat:appcompat:${v.appCompat}"
        const val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:${v.lifecycle}"
        const val activity = "androidx.activity:activity:${v.activity}"
        const val fragment = "androidx.fragment:fragment:${v.fragment}"
        const val fragmentKtx = "androidx.fragment:androidx.fragment:fragment-ktx:${v.fragment}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${v.constraintLayout}"
    }

    /**
     * kotlin libraries
     */
    object K {
        const val bom = "org.jetbrains.kotlin:kotlin-bom"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${v.coroutines}"
    }

    /**
     * test libraries
     */
    object T {
        const val junit = "junit:junit:${v.junit}"
        const val xJunit = "androidx.test.ext:junit:${v.xJunit}"
        const val espresso = "androidx.test.espresso:espresso-core:${v.espresso}"
    }

}