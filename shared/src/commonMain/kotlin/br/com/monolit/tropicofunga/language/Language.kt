package br.com.monolit.tropicofunga.language

enum class Language(val code: String) {
    EN("en"),
    PT("pt"),
    ES("es");

    companion object {
        val Default = EN

        fun fromCode(code: String?): Language? = entries.firstOrNull { it.code == code }
    }
}
