package br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.view

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.data.GlossaryOrder
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.data.GlossaryViewState
import br.com.monolit.tropicofunga.features.shared.views.DefaultDropdownMenuView
import br.com.monolit.tropicofunga.features.shared.views.DefaultSearchableView
import br.com.monolit.tropicofunga.features.shared.views.ErrorMessageView
import br.com.monolit.tropicofunga.features.shared.views.LoadView
import br.com.monolit.tropicofunga.repository.impl.staticData.glossaryData
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.stringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.loading_glossary_message
import tropicofunga.shared.generated.resources.order_by_format
import tropicofunga.shared.generated.resources.results_found_format
import tropicofunga.shared.generated.resources.search_for_term_or_definition_placeholder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GlossaryView(
    modifier: Modifier,
    searchQuery: String,
    ordersList: List<GlossaryOrder>,
    selectedOrder: GlossaryOrder,
    viewState: GlossaryViewState,
    onQueryChanged: (String) -> Unit,
    onBackPressed: () -> Unit,
    updateOrderRequested: (GlossaryOrder) -> Unit,
    onTryLoadAgainRequest: () -> Unit,
) {
    DefaultSearchableView(
        modifier = modifier,
        searchQuery = searchQuery,
        placeholder = stringResource(Res.string.search_for_term_or_definition_placeholder),
        showFiltersButton = false,
        onQueryChanged = onQueryChanged,
        onBackPressed = onBackPressed,
    ) {
        val contentModifier = Modifier.fillMaxSize().padding(vertical = 8.dp)
        AnimatedContent(viewState) { state ->
            when (state) {
                GlossaryViewState.Loading -> {
                    LoadView(
                        modifier = contentModifier,
                        message = stringResource(Res.string.loading_glossary_message)
                    )
                }

                is GlossaryViewState.Error -> {
                    ErrorMessageView(
                        modifier = contentModifier,
                        message = state.message,
                        onTryAgainRequest = onTryLoadAgainRequest,
                    )
                }

                is GlossaryViewState.Loaded -> {
                    val list = state.glossary
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

                        LazyColumn(
                            modifier = Modifier.fillMaxWidth().weight(1f),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            items(
                                items = list,
                                key = { item -> item.id }
                            ) { entry ->
                                GlossaryItemView(
                                    modifier = Modifier.fillMaxWidth().animateItem(),
                                    item = entry,
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
private fun GlossaryPreview() {
    AppTheme {
        GlossaryView(
            modifier = Modifier.fillMaxSize(),
            searchQuery = "",
            ordersList = GlossaryOrder.entries,
            selectedOrder = GlossaryOrder.TERM_ASC,
            viewState = GlossaryViewState.Loaded(glossaryData),
            onQueryChanged = {},
            onBackPressed = {},
            updateOrderRequested = {},
            onTryLoadAgainRequest = {},
        )
    }
}