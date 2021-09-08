@file:Suppress("unused")

package me.daemon.infrastructure.application

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
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

@Suppress("DEPRECATION")
@Deprecated(
    "use longVersionCode instead",
    ReplaceWith("longVersionCode")
)
val Context.versionCode: Int
    get() = this.packageInfo.versionCode

val Context.longVersionCode: Long
    get() = PackageInfoCompat.getLongVersionCode(this.packageInfo)

val Context.versionName: String
    get() = this.packageInfo.versionName

@RequireInfrastructureApp
val debuggable: Boolean
    get() = application.debuggable

@RequireInfrastructureApp
val packageInfo: PackageInfo
    get() = application.packageInfo

@RequireInfrastructureApp
@Deprecated(
    "use longVersionCode instead",
    ReplaceWith("longVersionCode")
)
@Suppress("DEPRECATION")
val versionCode: Int
    get() = application.versionCode

@RequireInfrastructureApp
val longVersionCode: Long
    get() = PackageInfoCompat.getLongVersionCode(packageInfo)

@RequireInfrastructureApp
val versionName: String
    get() = packageInfo.versionName

@RequireInfrastructureApp
val packageName: String
    get() = application.packageName
