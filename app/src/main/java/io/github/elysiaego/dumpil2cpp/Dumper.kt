package io.github.elysiaego.dumpil2cpp

import android.util.Log
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.callbacks.XC_LoadPackage

class Dumper : IXposedHookLoadPackage {
    companion object {
        const val TAG = "ElysiaHook"
    }
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (lpparam.processName != lpparam.packageName) return
        try {
            System.loadLibrary("Elysia")
            Log.d(TAG, "Elysia loaded for ${lpparam.packageName}")
        } catch (e: Throwable) {
            e.message?.let { Log.e(TAG, it) }
        }
    }
}