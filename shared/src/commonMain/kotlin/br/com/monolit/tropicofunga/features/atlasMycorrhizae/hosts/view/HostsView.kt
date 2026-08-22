package br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.view

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.monolit.tropicofunga.data.DataImage
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data.HostsFilter
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data.HostsFilterType
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data.HostsOrder
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data.HostsViewState
import br.com.monolit.tropicofunga.features.shared.views.DefaultDropdownMenuView
import br.com.monolit.tropicofunga.features.shared.views.DefaultSearchableView
import br.com.monolit.tropicofunga.features.shared.views.EmptyStateView
import br.com.monolit.tropicofunga.features.shared.views.ErrorMessageView
import br.com.monolit.tropicofunga.features.shared.views.LoadView
import br.com.monolit.tropicofunga.features.shared.views.filterSection
import br.com.monolit.tropicofunga.features.shared.views.filterSelectableItem
import br.com.monolit.tropicofunga.repository.impl.staticData.hostsData
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.stringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.loading_hosts_message
import tropicofunga.shared.generated.resources.order_by_format
import tropicofunga.shared.generated.resources.results_found_format
import tropicofunga.shared.generated.resources.search_for_host_placeholder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostsView(
    modifier: Modifier,
    searchQuery: String,
    filters: Map<HostsFilterType, HostsFilter>,
    ordersList: List<HostsOrder>,
    selectedOrder: HostsOrder,
    viewState: HostsViewState,
    drawerState: DrawerState,
    onQueryChanged: (String) -> Unit,
    onBackPressed: () -> Unit,
    onFilterPressed: () -> Unit,
    updateFilterRequested: (HostsFilterType, HostsFilter) -> Unit,
    updateOrderRequested: (HostsOrder) -> Unit,
    onTryLoadAgainRequest: () -> Unit,
    openImageRequest: (DataImage) -> Unit,
) {
    DefaultSearchableView(
        modifier = modifier,
        searchQuery = searchQuery,
        placeholder = stringResource(Res.string.search_for_host_placeholder),
        drawerState = drawerState,
        filters = {
            filters.forEach { (filterType, filter) ->
                when (filter) {
                    is HostsFilter.MultipleSelection -> {
                        filterSection(
                            title = { stringResource(filterType.title) },
                            expanded = filter.expanded,
                            onClick = {
                                updateFilterRequested(
                                    filterType, filter.copy(
                                        expanded = !filter.expanded
                                    )
                                )
                            },
                        ) {
                            filter.options.forEach { option ->
                                val selected = option.id in filter.selected
                                filterSelectableItem(
                                    title = option.name,
                                    selected = selected,
                                    onClick = {
                                        updateFilterRequested(
                                            filterType, filter.copy(
                                                selected = if (selected) {
                                                    filter.selected - option.id
                                                } else {
                                                    filter.selected + option.id
                                                }
                                            )
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }
        },
        onQueryChanged = onQueryChanged,
        onBackPressed = onBackPressed,
        onFilterPressed = onFilterPressed,
    ) {
        val contentModifier = Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 8.dp)
        AnimatedContent(viewState) { state ->
            when (state) {
                is HostsViewState.Loading -> {
                    LoadView(
                        modifier = contentModifier,
                        message = stringResource(Res.string.loading_hosts_message)
                    )
                }

                is HostsViewState.Error -> {
                    ErrorMessageView(
                        modifier = contentModifier,
                        message = state.message,
                        onTryAgainRequest = onTryLoadAgainRequest,
                    )
                }

                is HostsViewState.Loaded -> {
                    val list = state.hosts
                    Column(
                        modifier = contentModifier,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(
                                text = stringResource(Res.string.results_found_format, list.size),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.outline,
                            )

                            DefaultDropdownMenuView(
                                items = ordersList,
                                selectedItem = selectedOrder,
                                onItemSelected = updateOrderRequested,
                                labelMaker = { stringResource(Res.string.order_by_format, stringResource(it.title)) },
                                itemLabelMaker = { stringResource(it.title) }
                            )
                        }

                        if (list.isEmpty()) {
                            Box(
                                modifier = Modifier.fillMaxWidth().weight(1f),
                                contentAlignment = Alignment.Center,
                            ) {
                                EmptyStateView(modifier = Modifier.fillMaxWidth())
                            }
                        } else {
                            LazyVerticalStaggeredGrid(
                                modifier = Modifier.fillMaxWidth().weight(1f),
                                columns = StaggeredGridCells.Fixed(2),
                                verticalItemSpacing = 8.dp,
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                            ) {
                                items(
                                    items = list,
                                    key = { item -> item.id }
                                ) { host ->
                                    HostItemView(
                                        modifier = Modifier.height(250.dp).animateItem(),
                                        item = host,
                                        onClick = {
                                            host.image?.let { openImageRequest(it) }
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HostsPreview() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    AppTheme {
        HostsView(
            modifier = Modifier.fillMaxSize(),
            searchQuery = "",
            filters = emptyMap(),
            ordersList = HostsOrder.entries,
            selectedOrder = HostsOrder.NAME_ASC,
            viewState = HostsViewState.Loaded(hostsData),
            drawerState = drawerState,
            onQueryChanged = {},
            onBackPressed = {},
            onFilterPressed = {},
            updateOrderRequested = {},
            updateFilterRequested = { _, _ -> },
            onTryLoadAgainRequest = {},
            openImageRequest = {}
        )
    }
}