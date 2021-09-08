# android-infrastructure-application

## 添加依赖

`build.gradle`文件中添加：

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation "io.github.daemon369:android-infrastructure-application:0.1.1"
}
```

可以在<https://mvnrepository.com/artifact/io.github.daemon369/android-infrastructure-application>查询最新版本

## 问题

如果遇到如下错误：

    Cannot inline bytecode built with JVM target 1.8 into bytecode that is being built with JVM target 1.6. Please specify proper '-jvm-target' option
    Adding support for Java 8 language features could solve this issue.

解决方法：

```gradle
// build.gradle
android {
    // ...
    compileOptions {
        targetCompatibility JavaVersion.VERSION_1_8
        sourceCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
```

## 功能介绍

通用`Application`实现，应用使用`InfrastructureApp`或其子类来作为自定义`Application`时，可以简化基础支持库的很多功能的使用

### 使用

#### 使用`AndroidManifest.xml`设置为默认`Application`实现：

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="me.daemon.infrastructure.application.demo">

    <application
        android:name="me.daemon.infrastructure.application.InfrastructureApp">
        ...
    </application>

</manifest>
```

#### 使用自定义`Application`继承`me.daemon.infrastructure.application.InfrastructureApp`类

```kotlin
package me.daemon.infrastructure.application.demo

import me.daemon.infrastructure.application.InfrastructureApp

class DemoApplication : InfrastructureApp() {
}
```

#### 应用

```kotlin
fun getString(@StringRes strId: Int): String {
    return application.getString(strId)
}
```
