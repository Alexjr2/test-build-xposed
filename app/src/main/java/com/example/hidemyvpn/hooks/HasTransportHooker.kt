package com.example.hidemyvpn.hooks

import android.net.NetworkCapabilities
import com.example.hidemyvpn.HideMyVPN
import io.github.libxposed.api.XposedInterface
import io.github.libxposed.api.annotations.BeforeInvocation
import io.github.libxposed.api.annotations.XposedHooker

private lateinit var hideMyVPN: HideMyVPN

@XposedHooker
class HasTransportHooker (module: HideMyVPN): XposedInterface.Hooker  {

    init {
        hideMyVPN = module
    }

    companion object {
        @JvmStatic
        @BeforeInvocation
        @Suppress("unused")
        fun beforeInvocation(callback: XposedInterface.BeforeHookCallback) {
            val transport = callback.args[0] as Int
//            hideMyVPN.log("Transport: $transport")
            if (transport == NetworkCapabilities.TRANSPORT_VPN) {
                callback.returnAndSkip(false)
            }
//            callback.returnAndSkip(false)
        }
    }
}