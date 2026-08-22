package br.com.monolit.tropicofunga.log

import kotlin.experimental.ExperimentalNativeApi
import kotlin.native.Platform
import platform.Foundation.NSLog

@OptIn(ExperimentalNativeApi::class)
actual val defaultLogLevel: LogLevel = if (Platform.isDebugBinary) LogLevel.DEBUG else LogLevel.NONE

actual fun platformLog(level: LogLevel, tag: String, message: String, throwable: Throwable?) {
    if (level == LogLevel.NONE) return
    val throwableSuffix = throwable?.let { " - ${it.message}" }.orEmpty()
    NSLog("[$tag] ${level.name}: $message$throwableSuffix")
}
