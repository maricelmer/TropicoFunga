package br.com.monolit.tropicofunga.features.home.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.compose.LocalIsDarkTheme
import org.jetbrains.compose.resources.painterResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.atlas_mycorrhizae_icon
import tropicofunga.shared.generated.resources.background_home_dark
import tropicofunga.shared.generated.resources.background_home_light
import tropicofunga.shared.generated.resources.funga_icon
import tropicofunga.shared.generated.resources.micolab_logo_black

@Composable
fun HomeView(
    modifier: Modifier,
    openFunga: () -> Unit,
    openAtlasMycorrhizae: () -> Unit,
) {
    val scrollState = rememberScrollState()
    val isDarkTheme = LocalIsDarkTheme.current

    val cardSize = 112.dp
    val cardModifier = Modifier.size(cardSize)
    Scaffold(modifier = modifier) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(
                    if (isDarkTheme) {
                        Res.drawable.background_home_dark
                    } else {
                        Res.drawable.background_home_light
                    }
                ),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
                contentDescription = null,
            )
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Column {
                        Text(
                            text = "Neotropical diversity of", // TODO internationalize
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Text(
                            text = "Fungy and Mycorrhizae", // TODO internationalize
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }

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
                            title = "Funga", // TODO internationalize
                            icon = painterResource(Res.drawable.funga_icon),
                            onClick = openFunga,
                        )
                        FeatureCardView(
                            modifier = cardModifier,
                            title = "Atlas of Mycorrhizae", // TODO internationalize
                            icon = painterResource(Res.drawable.atlas_mycorrhizae_icon),
                            onClick = openAtlasMycorrhizae,
                        )
                    }
                }

                Card(shape = RectangleShape) {
                    Image(
                        modifier = Modifier.width(cardSize),
                        painter = painterResource(Res.drawable.micolab_logo_black),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    AppTheme(darkTheme = false) {
        HomeView(
            modifier = Modifier.fillMaxSize(),
            openFunga = {},
            openAtlasMycorrhizae = {},
        )
    }
}