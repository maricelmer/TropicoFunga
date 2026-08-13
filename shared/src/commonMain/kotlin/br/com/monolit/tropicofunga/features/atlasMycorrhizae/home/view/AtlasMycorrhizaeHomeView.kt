package br.com.monolit.tropicofunga.features.atlasMycorrhizae.home.view

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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import br.com.monolit.tropicofunga.features.home.view.FeatureCardView
import com.example.compose.AppTheme
import com.example.compose.onSurfaceVariantLight
import com.example.compose.primaryContainerDark
import com.example.compose.surfaceVariantLight
import org.jetbrains.compose.resources.painterResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.atlas_mycorrhizae_background

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AtlasMycorrhizaeHomeView(
    modifier: Modifier,
    openEctomycorrhizae: () -> Unit,
    openHowToCollect: () -> Unit,
    openGlossary: () -> Unit,
    openFungi: () -> Unit,
    openHosts: () -> Unit,
    openAbout: () -> Unit,
    onBackPressed: () -> Unit,
) {
    val scrollState = rememberScrollState()

    val textShadow = Shadow(
        color = Color.Black, // Shadow tint
        offset = Offset(x = 6f, y = 6f),        // Direction and distance
        blurRadius = 3f                         // Edge softness
    )
    val cardModifier = Modifier.size(112.dp)
    val cardColors = CardDefaults.cardColors(
        containerColor = surfaceVariantLight,
        contentColor = onSurfaceVariantLight,
    )
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            tint = Color.White,
                            contentDescription = null,
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = Color.Transparent,
                )
            )
        },
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.atlas_mycorrhizae_background),
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
                            // TODO verify this style
                            append("Atlas of ")
                            withStyle(SpanStyle(color = primaryContainerDark)) {
                                append("Neotropical")
                            }
                            append(" Mycorrhizae")
                        },
                        style = MaterialTheme.typography.displayLarge.copy(shadow = textShadow),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                    )
                    Text(
                        text = "Illustrated guide to mycorrhiza identification",
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
                        title = "Ectomycorrhizae",
                        icon = rememberVectorPainter(Icons.Outlined.Info),
                        colors = cardColors,
                        onClick = openEctomycorrhizae,
                    )
                    FeatureCardView(
                        modifier = cardModifier,
                        title = "How to collect",
                        icon = rememberVectorPainter(Icons.Outlined.Info),
                        colors = cardColors,
                        onClick = openHowToCollect,
                    )
                    FeatureCardView(
                        modifier = cardModifier,
                        title = "Glossary",
                        icon = rememberVectorPainter(Icons.Outlined.Info),
                        colors = cardColors,
                        onClick = openGlossary,
                    )
                    FeatureCardView(
                        modifier = cardModifier,
                        title = "Fungi",
                        icon = rememberVectorPainter(Icons.Outlined.Info),
                        colors = cardColors,
                        onClick = openFungi,
                    )
                    FeatureCardView(
                        modifier = cardModifier,
                        title = "Hosts",
                        icon = rememberVectorPainter(Icons.Outlined.Info),
                        colors = cardColors,
                        onClick = openHosts,
                    )
                    FeatureCardView(
                        modifier = cardModifier,
                        title = "About",
                        icon = rememberVectorPainter(Icons.Outlined.Info),
                        colors = cardColors,
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
private fun AtlasMycorrhizaeHomePreview() {
    AppTheme(darkTheme = true) {
        AtlasMycorrhizaeHomeView(
            modifier = Modifier.fillMaxSize(),
            openEctomycorrhizae = {},
            openHowToCollect = {},
            openGlossary = {},
            openFungi = {},
            openHosts = {},
            openAbout = {},
            onBackPressed = {},
        )
    }
}