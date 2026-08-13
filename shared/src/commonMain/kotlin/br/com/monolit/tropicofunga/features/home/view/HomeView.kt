package br.com.monolit.tropicofunga.features.home.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.compose.primaryContainerDark
import org.jetbrains.compose.resources.painterResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.home_background

@Composable
fun HomeView(
    modifier: Modifier,
    openEctomycorrhizae: () -> Unit,
    openHowToCollect: () -> Unit,
    openGlossary: () -> Unit,
    openFungi: () -> Unit,
    openHosts: () -> Unit,
    openAbout: () -> Unit,
) {
    val scrollState = rememberScrollState()

    val textShadow = Shadow(
        color = Color.Black, // Shadow tint
        offset = Offset(x = 6f, y = 6f),        // Direction and distance
        blurRadius = 3f                         // Edge softness
    )
    val cardModifier = Modifier.size(112.dp)
    Scaffold(modifier = modifier) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.home_background),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopEnd,
                contentDescription = null,
            )
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = buildAnnotatedString {
                            append("Atlas de Micorrizas ")
                            withStyle(SpanStyle(color = primaryContainerDark)) {
                                append("Neotropicais")
                            }
                        },
                        style = MaterialTheme.typography.displayLarge.copy(shadow = textShadow),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                    )
                    Text(
                        text = "Guia ilustrado para identificação de micorrizas",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium.copy(shadow = textShadow)
                    )
                }

                Spacer(Modifier)

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        8.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        8.dp,
                        alignment = Alignment.CenterVertically
                    ),
                    itemVerticalAlignment = Alignment.CenterVertically,
                ) {
                    FeatureCardView(
                        modifier = cardModifier,
                        title = "Ectomicorrizas",
                        icon = rememberVectorPainter(Icons.Outlined.Info),
                        onClick = openEctomycorrhizae,
                    )
                    FeatureCardView(
                        modifier = cardModifier,
                        title = "Como coletar",
                        icon = rememberVectorPainter(Icons.Outlined.Info),
                        onClick = openHowToCollect,
                    )
                    FeatureCardView(
                        modifier = cardModifier,
                        title = "Glossário",
                        icon = rememberVectorPainter(Icons.Outlined.Info),
                        onClick = openGlossary,
                    )
                    FeatureCardView(
                        modifier = cardModifier,
                        title = "Fungos",
                        icon = rememberVectorPainter(Icons.Outlined.Info),
                        onClick = openFungi,
                    )
                    FeatureCardView(
                        modifier = cardModifier,
                        title = "Hospedeiros",
                        icon = rememberVectorPainter(Icons.Outlined.Info),
                        onClick = openHosts,
                    )
                    FeatureCardView(
                        modifier = cardModifier,
                        title = "Sobre",
                        icon = rememberVectorPainter(Icons.Outlined.Info),
                        onClick = openAbout,
                    )
                }

                Spacer(Modifier)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    AppTheme {
        HomeView(
            modifier = Modifier.fillMaxSize(),
            openEctomycorrhizae = {},
            openHowToCollect = {},
            openGlossary = {},
            openFungi = {},
            openHosts = {},
            openAbout = {},
        )
    }
}