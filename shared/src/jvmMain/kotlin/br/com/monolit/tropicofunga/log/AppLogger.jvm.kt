package br.com.monolit.tropicofunga.log

import java.util.logging.Level
import java.util.logging.Logger

// desktopApp/build.gradle.kts has no distinct debug/release build type today, so there is no
// reliable signal to gate on here; defaults to DEBUG. Revisit if a release build type is added.
actual val defaultLogLevel: LogLevel = LogLevel.DEBUG

actual fun platformLog(level: LogLevel, tag: String, message: String, throwable: Throwable?) {
    val javaLevel = when (level) {
        LogLevel.DEBUG -> Level.FINE
        LogLevel.INFO -> Level.INFO
        LogLevel.WARN -> Level.WARNING
        LogLevel.ERROR -> Level.SEVERE
        LogLevel.NONE -> return
    }
    val logger = Logger.getLogger(tag)
    if (throwable != null) {
        logger.log(javaLevel, message, throwable)
    } else {
        logger.log(javaLevel, message)
    }
}
