buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.gradle)
        classpath(libs.kotlin.plugin)
    }
}

tasks.create<Delete>("clean") {
    delete(rootProject.buildDir)
}

//allprojects {
//    println("project->${this.name}")
//    println("ext.ossrhUsername=${ext["ossrhUsername"]}")
//    println("ext.ossrhPassword=${ext["ossrhPassword"]}")
//    println("ext.sonatypeStagingProfileId=${ext["sonatypeStagingProfileId"]}")
//    println("ext.signing.keyId=${ext["signing.keyId"]}")
//    println("ext.signing.password=${ext["signing.password"]}")
//    println("ext.signing.secretKeyRingFile=${ext["signing.secretKeyRingFile"]}")
//}