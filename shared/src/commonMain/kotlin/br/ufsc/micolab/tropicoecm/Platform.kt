package br.ufsc.micolab.tropicoecm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform