package br.com.monolit.tropicofunga.log

import android.content.Context
import android.content.pm.ApplicationInfo
import android.util.Log
import org.koin.core.context.GlobalContext

// Reads the ApplicationInfo.FLAG_DEBUGGABLE flag off the Context Koin already holds (registered
// via androidContext(...) in BaseApplication) rather than a generated BuildConfig: the `shared`
// module doesn't have buildConfig enabled, and this flag reflects the build type (debug/release)
// automatically without needing it. Falls back to NONE (silent) if Koin isn't ready yet.
actual val defaultLogLevel: LogLevel
    get() {
        val context = GlobalContext.getOrNull()?.getOrNull<Context>()
        val debuggable = context?.applicationInfo
            ?.let { it.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0 }
            ?: false
        return if (debuggable) LogLevel.DEBUG else LogLevel.NONE
    }

actual fun platformLog(level: LogLevel, tag: String, message: String, throwable: Throwable?) {
    when (level) {
        LogLevel.DEBUG -> Log.d(tag, message, throwable)
        LogLevel.INFO -> Log.i(tag, message, throwable)
        LogLevel.WARN -> Log.w(tag, message, throwable)
        LogLevel.ERROR -> Log.e(tag, message, throwable)
        LogLevel.NONE -> Unit
    }
}
