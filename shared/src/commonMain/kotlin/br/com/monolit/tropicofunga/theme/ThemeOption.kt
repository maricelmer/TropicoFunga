package br.com.monolit.tropicofunga.theme

enum class ThemeOption {
    LIGHT,
    DARK,
    SYSTEM;

    companion object {
        val Default = SYSTEM

        fun fromName(name: String?): ThemeOption? = entries.firstOrNull { it.name == name }
    }
}
