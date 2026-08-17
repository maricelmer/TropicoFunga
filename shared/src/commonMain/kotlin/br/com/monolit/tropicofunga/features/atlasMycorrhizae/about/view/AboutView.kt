package br.com.monolit.tropicofunga.features.atlasMycorrhizae.about.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.SouthAmerica
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.monolit.tropicofunga.features.shared.views.DefaultScaffold
import br.com.monolit.tropicofunga.features.shared.views.EmailLinkText
import br.com.monolit.tropicofunga.features.shared.views.appBar.DefaultAppBar
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.painterResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.ecm_icon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutView(
    modifier: Modifier,
    onBackPressed: () -> Unit,
    onOpenContributeFormRequested: () -> Unit,
) {
    val scrollState = rememberScrollState()
    DefaultScaffold(
        modifier = modifier,
        topBar = {
            DefaultAppBar(
                title = "About",
                onBackPressed = onBackPressed,
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                AboutSectionView(
                    modifier = Modifier.fillMaxWidth().padding(),
                    icon = painterResource(Res.drawable.ecm_icon),
                    text = "Although ectomycorrhizal diversity in temperate regions is well documented, information regarding the morphotypes present in the Neotropics remains scattered throughout the literature. This atlas aims to help bridge this gap by consolidating records into a single reference resource." // TODO internationalize
                )
                AboutSectionView(
                    modifier = Modifier.fillMaxWidth().padding(),
                    icon = rememberVectorPainter(Icons.Outlined.School),
                    text = "This initial version compiles the ectomycorrhizal morphotypes recorded in Brazilian restinga environments and was developed as part of the doctoral thesis of Marivane Celmer Slodkowski, affiliated with the Graduate Program in Fungal, Algal, and Plant Biology at the Federal University of Santa Catarina (UFSC), Brazil." // TODO internationalize
                )
                AboutSectionView(
                    modifier = Modifier.fillMaxWidth().padding(),
                    icon = rememberVectorPainter(Icons.AutoMirrored.Outlined.MenuBook),
                    text = "This app was conceived as a constantly updated knowledge platform. Its objective is to gather, organize, and standardize information produced by different research groups, creating an integrated database that facilitates consultation, comparison between morphotypes, and the identification of ectomycorrhizae in the Neotropical region." // TODO internationalize
                )
                AboutSectionView(
                    modifier = Modifier.fillMaxWidth().padding(),
                    icon = rememberVectorPainter(Icons.Outlined.SouthAmerica),
                    text = "Future updates are expected to incorporate new records, progressively expanding knowledge about Neotropical ectomycorrhizal diversity and contributing to advances in research on systematics, ecology, and conservation of these symbionts." // TODO internationalize
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "To contribute to this project, access our form below.", // TODO internationalize
                    style = MaterialTheme.typography.labelLarge,
                    textAlign = TextAlign.Center,
                )

                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = onOpenContributeFormRequested,
                ) {
                    Text(
                        text = "Open contribute form", // TODO internationalize
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Center,
                    )
                }

                FlowRow(
                    itemVerticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = "Questions and suggestions:", // TODO internationalize
                        style = MaterialTheme.typography.labelSmall,
                    )
                    EmailLinkText(email = "neotropicalecmatlas@gmail.com")
                }

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Thank you!", // TODO internationalize
                    style = MaterialTheme.typography.titleLarge.copy(fontStyle = FontStyle.Italic),
                    textAlign = TextAlign.Center,
                )
            }

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Curatorship", // TODO internationalize
                style = MaterialTheme.typography.labelSmall,
            )

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = "Marivane Celmer Slodkowski",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Text(
                        text = "Maria Alice Neves",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AboutPreview() {
    AppTheme(darkTheme = false) {
        AboutView(
            modifier = Modifier.fillMaxSize(),
            onBackPressed = {},
            onOpenContributeFormRequested = {},
        )
    }
}

@Composable
fun AboutSectionView(
    modifier: Modifier,
    icon: Painter,
    text: String,
) {
    val contentColor = MaterialTheme.colorScheme.primary
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            modifier = Modifier
                .size(48.dp)
                .border(width = 1.dp, color = contentColor, shape = CircleShape)
                .padding(8.dp),
            painter = icon,
            contentDescription = "About section icon", // TODO internationalize
            tint = contentColor,
        )
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview
@Composable
private fun AboutSectionPreview() {
    AppTheme(darkTheme = false) {
        AboutSectionView(
            modifier = Modifier.fillMaxWidth(),
            icon = painterResource(Res.drawable.ecm_icon),
            text = "Although ectomycorrhizal diversity in temperate regions is well documented, information regarding the morphotypes present in the Neotropics remains scattered throughout the literature. This atlas aims to help bridge this gap by consolidating records into a single reference resource."
        )
    }
}