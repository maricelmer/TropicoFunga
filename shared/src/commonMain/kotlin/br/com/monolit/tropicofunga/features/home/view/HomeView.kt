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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.compose.LocalIsDarkTheme
import org.jetbrains.compose.resources.painterResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.background_home
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
            Icon(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.background_home),
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
                            text = "Neotropical diversity of",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Text(
                            text = "Fungy and Mycorrhizae",
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
                            title = "Funga",
                            icon = rememberVectorPainter(Icons.Outlined.Info),
                            onClick = openFunga,
                        )
                        FeatureCardView(
                            modifier = cardModifier,
                            title = "Atlas of Mycorrhizae",
                            icon = rememberVectorPainter(Icons.Outlined.Info),
                            onClick = openAtlasMycorrhizae,
                        )
                    }
                }

                Image(
                    modifier = Modifier.width(cardSize),
                    painter = if (isDarkTheme) {
                        painterResource(Res.drawable.micolab_logo_black)
                    } else {
                        painterResource(Res.drawable.micolab_logo_black) // TODO change this
                    },
                    contentDescription = null,
                )
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