@file:Suppress("unused")

package me.daemon.infrastructure.application

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.pm.PackageInfoCompat
import me.daemon.annotation.RequireInfrastructureApp

/**
 * @author daemon
 * @since 2021/6/15 15:26
 */
open class InfrastructureApp : Application() {

    companion object {
        internal var instance: InfrastructureApp? = null
    }

    init {
        @Suppress("LeakingThis")
        instance = this
    }

}

/**
 * instance of InfrastructureApp
 */
@RequireInfrastructureApp
val application: InfrastructureApp
    get() = InfrastructureApp.instance ?: throw IllegalAccessException(
        "You should set 'application' tag's 'android:name' attribute to InfrastructureApp or it's" +
                " subclass in your AndroidManifest.xml"
    )

val Context.debuggable: Boolean
    get() = this.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0

val Context.packageInfo: PackageInfo
    get() = this.packageManager.getPackageInfo(this.packageName, 0)

val Context.longVersionCode: Long
    get() = PackageInfoCompat.getLongVersionCode(this.packageInfo)

val Context.versionName: String
    get() = this.packageInfo.versionName

val Context.minSdkVersion: Int
    @RequiresApi(Build.VERSION_CODES.N)
    get() = this.packageInfo.applicationInfo.minSdkVersion

val Context.compileSdkVersion: Int
    @RequiresApi(Build.VERSION_CODES.S)
    get() = this.packageInfo.applicationInfo.compileSdkVersion

val Context.targetSdkVersion: Int
    get() = this.packageInfo.applicationInfo.targetSdkVersion


@RequireInfrastructureApp
val debuggable: Boolean
    get() = application.debuggable

@RequireInfrastructureApp
val packageInfo: PackageInfo
    get() = application.packageInfo

@RequireInfrastructureApp
val longVersionCode: Long
    get() = PackageInfoCompat.getLongVersionCode(packageInfo)

@RequireInfrastructureApp
val versionName: String
    get() = packageInfo.versionName

@RequireInfrastructureApp
val packageName: String
    get() = application.packageName

@RequireInfrastructureApp
val minSdkVersion: Int
    @RequiresApi(Build.VERSION_CODES.N)
    get() = application.minSdkVersion

@RequireInfrastructureApp
val compileSdkVersion: Int
    @RequiresApi(Build.VERSION_CODES.S)
    get() = application.compileSdkVersion

@RequireInfrastructureApp
val targetSdkVersion: Int
    get() = application.targetSdkVersion
