package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaeFilter
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaeFilterType
import br.com.monolit.tropicofunga.features.shared.views.DefaultSearchableView
import br.com.monolit.tropicofunga.features.shared.views.filterSection
import br.com.monolit.tropicofunga.features.shared.views.filterSelectableItem
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.stringResource

@Composable
fun EctomycorrhizaeView(
    modifier: Modifier,
    searchQuery: String,
    filters: Map<EctomycorrhizaeFilterType, EctomycorrhizaeFilter>,
    drawerState: DrawerState,
    onQueryChanged: (String) -> Unit,
    onBackPressed: () -> Unit,
    onFilterPressed: () -> Unit,
    updateFilterRequested: (EctomycorrhizaeFilterType, EctomycorrhizaeFilter) -> Unit
) {
    DefaultSearchableView(
        modifier = modifier,
        searchQuery = searchQuery,
        placeholder = "Search for ectomycorrhiza", // TODO internationalize
        drawerState = drawerState,
        filters = {
            filters.forEach { (filterType, filter) ->
                when (filter) {
                    is EctomycorrhizaeFilter.MultipleSelection -> {
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
                            filter.options.forEachIndexed { index, option ->
                                val selected = index in filter.selected
                                filterSelectableItem(
                                    title = option,
                                    selected = selected,
                                    onClick = {
                                        updateFilterRequested(
                                            filterType,
                                            filter.copy(
                                                selected = if (selected) {
                                                    filter.selected - index
                                                } else {
                                                    filter.selected + index
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
        Text(text = searchQuery)
    }
}

@Preview(showBackground = true)
@Composable
private fun EctomycorrhizaePreview() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    AppTheme {
        EctomycorrhizaeView(
            modifier = Modifier.fillMaxSize(),
            searchQuery = "",
            filters = emptyMap(),
            drawerState = drawerState,
            onQueryChanged = {},
            onBackPressed = {},
            onFilterPressed = {},
            updateFilterRequested = { _, _ -> }
        )
    }
}