package com.example.hidemyvpn

import android.annotation.SuppressLint
import com.example.hidemyvpn.hooks.HasCapabilityHooker
import com.example.hidemyvpn.hooks.HasTransportHooker
import io.github.libxposed.api.XposedInterface
import io.github.libxposed.api.XposedModule
import io.github.libxposed.api.XposedModuleInterface


private lateinit var module: HideMyVPN

class HideMyVPN(base: XposedInterface, param: XposedModuleInterface.ModuleLoadedParam) :
    XposedModule(base, param) {

    init {
        module = this
    }

    @SuppressLint("PrivateApi")
    override fun onSystemServerLoaded(param: XposedModuleInterface.SystemServerLoadedParam) {
        super.onSystemServerLoaded(param)

        // Hook hasCapability
        try {
            hook(
                //https://cs.android.com/android/platform/superproject/main/+/main:packages/modules/Connectivity/framework/src/android/net/NetworkCapabilities.java?q=hasTransport
                //https://cs.android.com/android/platform/superproject/main/+/main:packages/modules/Connectivity/framework/src/android/net/NetworkCapabilities.java;l=1059;drc=074bb2dc367bde42b837a8de4d4e88f26c074c32?q=hasCapability
                param.classLoader.loadClass("android.net.NetworkCapabilities").getDeclaredMethod(
                        "isValidCapability", Int::class.java
                    ), HasCapabilityHooker::class.java
            )
//            log("[hasCapability] Hooked onSystemServerLoaded")
        } catch (e: Exception) {
            log("[hasCapability] ERROR: onSystemServerLoaded - $e")
        }

        // Hook hasTransport
        try {
            val hasTransportHooker = HasTransportHooker(this)
            hook(
                //https://cs.android.com/android/platform/superproject/main/+/main:packages/modules/Connectivity/framework/src/android/net/NetworkCapabilities.java?q=hasTransport
                //https://cs.android.com/android/platform/superproject/main/+/main:packages/modules/Connectivity/framework/src/android/net/NetworkCapabilities.java;l=1059;drc=074bb2dc367bde42b837a8de4d4e88f26c074c32?q=hasCapability
                param.classLoader.loadClass("android.net.NetworkCapabilities").getDeclaredMethod(
                        "hasTransport", Int::class.java
                    ), hasTransportHooker::class.java
            )
//            log("[hasTransport] Hooked onSystemServerLoaded")
        } catch (e: Exception) {
            log("[hasTransport] ERROR: onSystemServerLoaded $e")
        }
    }

    @SuppressLint("PrivateApi")
    override fun onPackageLoaded(param: XposedModuleInterface.PackageLoadedParam) {
        super.onPackageLoaded(param)

        // Hook hasCapability
        try {
            hook(
                //https://cs.android.com/android/platform/superproject/main/+/main:packages/modules/Connectivity/framework/src/android/net/NetworkCapabilities.java?q=hasTransport
                //https://cs.android.com/android/platform/superproject/main/+/main:packages/modules/Connectivity/framework/src/android/net/NetworkCapabilities.java;l=1059;drc=074bb2dc367bde42b837a8de4d4e88f26c074c32?q=hasCapability
                param.classLoader.loadClass("android.net.NetworkCapabilities").getDeclaredMethod(
                        "hasCapability", Int::class.java
                    ), HasCapabilityHooker::class.java
            )
//            log("[hasCapability] Hooked onPackageLoaded ${param.packageName}")
        } catch (e: Exception) {
            log("[hasCapability] ERROR: onPackageLoaded $e")
        }

        // Hook hasTransport
        try {
            hook(
                //https://cs.android.com/android/platform/superproject/main/+/main:packages/modules/Connectivity/framework/src/android/net/NetworkCapabilities.java?q=hasTransport
                //https://cs.android.com/android/platform/superproject/main/+/main:packages/modules/Connectivity/framework/src/android/net/NetworkCapabilities.java;l=1059;drc=074bb2dc367bde42b837a8de4d4e88f26c074c32?q=hasCapability
                param.classLoader.loadClass("android.net.NetworkCapabilities").getDeclaredMethod(
                        "hasTransport", Int::class.java
                    ), HasTransportHooker::class.java
            )
//            log("[hasTransport] Hooked onPackageLoaded ${param.packageName}")
        } catch (e: Exception) {
            log("[hasTransport] ERROR: onPackageLoaded $e")
        }
    }
}
