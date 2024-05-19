package com.example.hidemyvpn.hooks

import android.net.NetworkCapabilities
import io.github.libxposed.api.XposedInterface
import io.github.libxposed.api.annotations.BeforeInvocation
import io.github.libxposed.api.annotations.XposedHooker

@XposedHooker
class HasCapabilityHooker: XposedInterface.Hooker {
    companion object {
        @JvmStatic
        @BeforeInvocation
        @Suppress("unused")
        fun beforeInvocation(callback: XposedInterface.BeforeHookCallback) {
            val capability = callback.args[0] as Int
            if (capability == NetworkCapabilities.NET_CAPABILITY_NOT_VPN) {
                callback.returnAndSkip(false)
            }
//            if (capability == NetworkCapabilities.NET_CAPABILITY_NOT_VPN)
//            {callback.returnAndSkip(false)}
        }
    }
}