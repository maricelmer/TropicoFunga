package br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.view

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
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
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.data.FungiFilter
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.data.FungiFilterType
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.data.FungiOrder
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.data.FungiViewState
import br.com.monolit.tropicofunga.features.shared.views.DefaultDropdownMenuView
import br.com.monolit.tropicofunga.features.shared.views.DefaultSearchableView
import br.com.monolit.tropicofunga.features.shared.views.ErrorMessageView
import br.com.monolit.tropicofunga.features.shared.views.LoadView
import br.com.monolit.tropicofunga.features.shared.views.filterSection
import br.com.monolit.tropicofunga.features.shared.views.filterSelectableItem
import br.com.monolit.tropicofunga.repository.impl.staticData.fungiData
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FungiView(
    modifier: Modifier,
    searchQuery: String,
    filters: Map<FungiFilterType, FungiFilter>,
    ordersList: List<FungiOrder>,
    selectedOrder: FungiOrder,
    viewState: FungiViewState,
    drawerState: DrawerState,
    onQueryChanged: (String) -> Unit,
    onBackPressed: () -> Unit,
    onFilterPressed: () -> Unit,
    updateFilterRequested: (FungiFilterType, FungiFilter) -> Unit,
    updateOrderRequested: (FungiOrder) -> Unit,
    onTryLoadAgainRequest: () -> Unit,
) {
    DefaultSearchableView(
        modifier = modifier,
        searchQuery = searchQuery,
        placeholder = "Search for fungus", // TODO internationalize
        drawerState = drawerState,
        filters = {
            filters.forEach { (filterType, filter) ->
                when (filter) {
                    is FungiFilter.MultipleSelection -> {
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
        val contentModifier = Modifier.fillMaxSize().padding(vertical = 8.dp)
        AnimatedContent(viewState) { state ->
            when (state) {
                FungiViewState.Loading -> {
                    LoadView(
                        modifier = contentModifier,
                        message = "Loading fungi..." // TODO internationalize
                    )
                }

                is FungiViewState.Error -> {
                    ErrorMessageView(
                        modifier = contentModifier,
                        message = state.message,
                        onTryAgainRequest = onTryLoadAgainRequest,
                    )
                }

                is FungiViewState.Loaded -> {
                    val list = state.fungi
                    Column(
                        modifier = contentModifier,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(
                                text = "${list.size} results found", // TODO internationalize
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.outline,
                            )

                            DefaultDropdownMenuView(
                                items = ordersList,
                                selectedItem = selectedOrder,
                                onItemSelected = updateOrderRequested,
                                labelMaker = { "Order by: ${it.title}" },
                                itemLabelMaker = { it.title }
                            )
                        }

                        LazyVerticalStaggeredGrid(
                            modifier = Modifier.fillMaxWidth().weight(1f)
                                .padding(horizontal = 16.dp),
                            columns = StaggeredGridCells.Fixed(2),
                            verticalItemSpacing = 8.dp,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            items(
                                items = list,
                                key = { item -> item.id }
                            ) { fungus ->
                                FungusItemView(
                                    modifier = Modifier.height(200.dp).animateItem(),
                                    item = fungus,
                                )
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
private fun FungiPreview() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    AppTheme {
        FungiView(
            modifier = Modifier.fillMaxSize(),
            searchQuery = "",
            filters = emptyMap(),
            ordersList = FungiOrder.entries,
            selectedOrder = FungiOrder.NAME_ASC,
            viewState = FungiViewState.Loaded(fungiData),
            drawerState = drawerState,
            onQueryChanged = {},
            onBackPressed = {},
            onFilterPressed = {},
            updateOrderRequested = {},
            updateFilterRequested = { _, _ -> },
            onTryLoadAgainRequest = {},
        )
    }
}
