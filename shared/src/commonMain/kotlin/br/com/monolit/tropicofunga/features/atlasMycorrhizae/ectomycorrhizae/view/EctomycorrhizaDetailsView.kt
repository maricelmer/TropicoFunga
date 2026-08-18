package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.view

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaDetailsViewState
import br.com.monolit.tropicofunga.features.shared.utils.toAnnotatedString
import br.com.monolit.tropicofunga.features.shared.views.DefaultDetailsView
import br.com.monolit.tropicofunga.features.shared.views.ErrorMessageView
import br.com.monolit.tropicofunga.features.shared.views.ImagePathCollectionView
import br.com.monolit.tropicofunga.features.shared.views.LoadView
import br.com.monolit.tropicofunga.repository.impl.staticData.ectomycorrhizaeData
import com.example.compose.AppTheme

@Composable
fun EctomycorrhizaDetailsView(
    modifier: Modifier,
    viewState: EctomycorrhizaDetailsViewState,
    onBackPressed: () -> Unit,
    onTryLoadAgainRequest: () -> Unit,
    onViewImagesRequest: (Int) -> Unit,
) {
    val scrollState = rememberScrollState()

    val tile by remember(viewState) {
        derivedStateOf {
            when (viewState) {
                is EctomycorrhizaDetailsViewState.Loaded -> {
                    viewState.ectomycorrhiza.name
                }

                is EctomycorrhizaDetailsViewState.Error,
                EctomycorrhizaDetailsViewState.Loading -> {
                    "".toAnnotatedString()
                }
            }
        }
    }
    DefaultDetailsView(
        modifier = modifier,
        title = tile,
        onBackPressed = onBackPressed,
    ) {
        val contentModifier = Modifier.fillMaxSize().padding(vertical = 8.dp)
        AnimatedContent(viewState) { state ->
            when (state) {

                EctomycorrhizaDetailsViewState.Loading -> {
                    LoadView(
                        modifier = contentModifier,
                        message = "Loading ectomycorrhiza..." // TODO internationalize
                    )
                }

                is EctomycorrhizaDetailsViewState.Error -> {
                    ErrorMessageView(
                        modifier = contentModifier,
                        message = state.message,
                        onTryAgainRequest = onTryLoadAgainRequest,
                    )
                }

                is EctomycorrhizaDetailsViewState.Loaded -> {
                    Column(
                        modifier = contentModifier.verticalScroll(scrollState),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        ImagePathCollectionView(
                            modifier = Modifier.fillMaxWidth()
                                .height(300.dp)
                                .padding(horizontal = 16.dp),
                            imagesPaths = state.ectomycorrhiza.images,
                            onViewImageRequest = onViewImagesRequest,
                        )

                        Text(
                            text = "Legend: ${
                                state.ectomycorrhiza.images.joinToString(", ") { it.legend }
                            }", // TODO internationalize
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.outline,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )

                        CharacteristicsSectionView(
                            modifier = Modifier.fillMaxWidth(),
                            title = "Diagnostic characters", // TODO internationalize
                        ) {
                            CharacteristicsItemView(
                                modifier = Modifier.fillMaxWidth(),
                                title = "Type:", // TODO internationalize
                                value = state.ectomycorrhiza.type.name
                            )
                            CharacteristicsItemView(
                                modifier = Modifier.fillMaxWidth(),
                                title = "Colour:", // TODO internationalize
                                value = state.ectomycorrhiza.colorDescription
                            )
                            CharacteristicsItemView(
                                modifier = Modifier.fillMaxWidth(),
                                title = "Hartig net:", // TODO internationalize
                                value = state.ectomycorrhiza.hartigNet.title
                            )
                            CharacteristicsItemView(
                                modifier = Modifier.fillMaxWidth(),
                                title = "Mantle thickness:", // TODO internationalize
                                value = state.ectomycorrhiza.mantleThickness
                            )
                            CharacteristicsItemView(
                                modifier = Modifier.fillMaxWidth(),
                                title = "Outer mantle layer:", // TODO internationalize
                                value = state.ectomycorrhiza.outerMantleLayer.title
                            )
                            CharacteristicsItemView(
                                modifier = Modifier.fillMaxWidth(),
                                title = "Hyphal strands:", // TODO internationalize
                                value = state.ectomycorrhiza.hyphalStrands.title
                            )
                        }
                        CharacteristicsSectionView(
                            modifier = Modifier.fillMaxWidth(),
                            title = "General Information", // TODO internationalize
                        ) {
                            CharacteristicsItemView(
                                modifier = Modifier.fillMaxWidth(),
                                title = "Ecosystem:", // TODO internationalize
                                value = state.ectomycorrhiza.ecosystem
                            )
                            CharacteristicsItemView(
                                modifier = Modifier.fillMaxWidth(),
                                title = "GenBank accession:", // TODO internationalize
                                value = state.ectomycorrhiza.genBankAccessionNumbers.joinToString(", ")
                            )
                            CharacteristicsItemView(
                                modifier = Modifier.fillMaxWidth(),
                                title = "References:", // TODO internationalize
                                value = state.ectomycorrhiza.references.joinToString(", ")
                            )
                        }
                        CharacteristicsSectionView(
                            modifier = Modifier.fillMaxWidth(),
                            title = "Morphological characters", // TODO internationalize
                        ) {
                            Text(
                                text = state.ectomycorrhiza.morphologicalCharacters,
                                style = MaterialTheme.typography.labelSmall,
                                textAlign = TextAlign.Justify,
                            )
                        }
                        CharacteristicsSectionView(
                            modifier = Modifier.fillMaxWidth(),
                            title = "Anatomical characters of mantle", // TODO internationalize
                        ) {
                            Text(
                                text = state.ectomycorrhiza.mantleAnatomicalCharacters,
                                style = MaterialTheme.typography.labelSmall,
                                textAlign = TextAlign.Justify,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun EctomycorrhizaDetailsPreview() {
    AppTheme(darkTheme = false) {
        EctomycorrhizaDetailsView(
            modifier = Modifier.fillMaxSize(),
            viewState = EctomycorrhizaDetailsViewState.Loaded(ectomycorrhiza = ectomycorrhizaeData.first()),
            onBackPressed = {},
            onTryLoadAgainRequest = {},
            onViewImagesRequest = {},
        )
    }
}

@Composable
fun CharacteristicsSectionView(
    modifier: Modifier,
    title: String,
    content: @Composable ColumnScope.() -> Unit,
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
            content()
        }
    }
}

@Preview
@Composable
private fun CharacteristicsSectionPreview() {
    AppTheme(darkTheme = false) {
        CharacteristicsSectionView(
            modifier = Modifier.fillMaxWidth(),
            title = "Diagnostic characteristics",
        ) {
            Text("Sample characteristic")
        }
    }
}

@Composable
fun CharacteristicsItemView(
    modifier: Modifier,
    title: String,
    value: String,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.SemiBold,
        )
        Text(
            text = value,
            style = MaterialTheme.typography.labelMedium,
        )
    }
}

@Preview
@Composable
private fun CharacteristicsItemPreview() {
    AppTheme(darkTheme = false) {
        CharacteristicsItemView(
            modifier = Modifier.fillMaxWidth(),
            title = "Type:",
            value = "Ectomycorrhiza"
        )
    }
}