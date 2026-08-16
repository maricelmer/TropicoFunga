package br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data

import br.com.monolit.tropicofunga.data.host.Host

sealed interface HostsViewState {
    data object Loading : HostsViewState
    data class Loaded(val hosts: List<Host>) : HostsViewState

    data class Error(val message: String) : HostsViewState
}