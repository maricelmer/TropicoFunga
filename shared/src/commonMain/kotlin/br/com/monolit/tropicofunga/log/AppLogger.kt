package br.com.monolit.tropicofunga.log

/** Ordered from most to least verbose. [NONE] disables all output. */
enum class LogLevel { DEBUG, INFO, WARN, ERROR, NONE }

/**
 * Platform-appropriate default visibility: [LogLevel.DEBUG] in debug builds, [LogLevel.NONE] in
 * release builds, so a release build stays silent unless [AppLogger.minLevel] is overridden.
 */
expect val defaultLogLevel: LogLevel

/** Platform output sink: Android uses `android.util.Log`, iOS uses `NSLog`, JVM uses `java.util.logging`. */
expect fun platformLog(level: LogLevel, tag: String, message: String, throwable: Throwable?)

/**
 * Local-only, offline logger (no network, no third-party crash-reporting SDK — keeps the app's
 * "no network calls" design from CLAUDE.md intact) with a configurable visibility level.
 *
 * Defaults to [defaultLogLevel] (silent in release, verbose in debug) but [minLevel] can be
 * overridden at runtime, e.g. to enable verbose logging temporarily while diagnosing an issue.
 */
object AppLogger {
    var minLevel: LogLevel = defaultLogLevel

    fun d(tag: String, message: String, throwable: Throwable? = null) = log(LogLevel.DEBUG, tag, message, throwable)
    fun i(tag: String, message: String, throwable: Throwable? = null) = log(LogLevel.INFO, tag, message, throwable)
    fun w(tag: String, message: String, throwable: Throwable? = null) = log(LogLevel.WARN, tag, message, throwable)
    fun e(tag: String, message: String, throwable: Throwable? = null) = log(LogLevel.ERROR, tag, message, throwable)

    private fun log(level: LogLevel, tag: String, message: String, throwable: Throwable?) {
        if (level < minLevel) return
        platformLog(level, tag, message, throwable)
    }
}
