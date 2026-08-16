package br.com.monolit.tropicofunga.repository

import br.com.monolit.tropicofunga.data.ectomycorrhiza.Ectomycorrhiza
import br.com.monolit.tropicofunga.data.fungus.Fungus
import br.com.monolit.tropicofunga.data.glossary.GlossaryEntry
import br.com.monolit.tropicofunga.data.host.Host
import kotlin.uuid.Uuid

interface AppRepository {
    suspend fun loadEctomycorrhizae(): Result<List<Ectomycorrhiza>>
    suspend fun loadEctomycorrhiza(id: Uuid): Result<Ectomycorrhiza?>

    suspend fun loadFungi(): Result<List<Fungus>>

    suspend fun loadHosts(): Result<List<Host>>

    suspend fun loadGlossary(): Result<List<GlossaryEntry>>
}