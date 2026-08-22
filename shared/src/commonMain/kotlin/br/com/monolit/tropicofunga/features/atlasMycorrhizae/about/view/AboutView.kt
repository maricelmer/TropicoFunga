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
import br.com.monolit.tropicofunga.features.shared.utils.toAnnotatedString
import br.com.monolit.tropicofunga.features.shared.views.DefaultScaffold
import br.com.monolit.tropicofunga.features.shared.views.EmailLinkText
import br.com.monolit.tropicofunga.features.shared.views.appBar.DefaultAppBar
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.about
import tropicofunga.shared.generated.resources.about_contribute_prompt
import tropicofunga.shared.generated.resources.about_curator_1_name
import tropicofunga.shared.generated.resources.about_curator_2_name
import tropicofunga.shared.generated.resources.about_curator_3_name
import tropicofunga.shared.generated.resources.about_curatorship_label
import tropicofunga.shared.generated.resources.about_open_contribute_form_button
import tropicofunga.shared.generated.resources.about_questions_suggestions_label
import tropicofunga.shared.generated.resources.about_section_1_text
import tropicofunga.shared.generated.resources.about_section_2_text
import tropicofunga.shared.generated.resources.about_section_3_text
import tropicofunga.shared.generated.resources.about_section_4_text
import tropicofunga.shared.generated.resources.about_section_icon_content_description
import tropicofunga.shared.generated.resources.about_thank_you
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
                title = stringResource(Res.string.about).toAnnotatedString(),
                onBackPressed = onBackPressed,
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                AboutSectionView(
                    modifier = Modifier.fillMaxWidth().padding(),
                    icon = painterResource(Res.drawable.ecm_icon),
                    text = stringResource(Res.string.about_section_1_text)
                )
                AboutSectionView(
                    modifier = Modifier.fillMaxWidth().padding(),
                    icon = rememberVectorPainter(Icons.Outlined.School),
                    text = stringResource(Res.string.about_section_2_text)
                )
                AboutSectionView(
                    modifier = Modifier.fillMaxWidth().padding(),
                    icon = rememberVectorPainter(Icons.AutoMirrored.Outlined.MenuBook),
                    text = stringResource(Res.string.about_section_3_text)
                )
                AboutSectionView(
                    modifier = Modifier.fillMaxWidth().padding(),
                    icon = rememberVectorPainter(Icons.Outlined.SouthAmerica),
                    text = stringResource(Res.string.about_section_4_text)
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.about_contribute_prompt),
                    style = MaterialTheme.typography.labelLarge,
                    textAlign = TextAlign.Center,
                )

                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = onOpenContributeFormRequested,
                ) {
                    Text(
                        text = stringResource(Res.string.about_open_contribute_form_button),
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Center,
                    )
                }

                FlowRow(
                    itemVerticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = stringResource(Res.string.about_questions_suggestions_label),
                        style = MaterialTheme.typography.labelSmall,
                    )
                    EmailLinkText(email = "neotropicalecmatlas@gmail.com")
                }

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.about_thank_you),
                    style = MaterialTheme.typography.titleLarge.copy(fontStyle = FontStyle.Italic),
                    textAlign = TextAlign.Center,
                )
            }

            Text(
                text = stringResource(Res.string.about_curatorship_label),
                style = MaterialTheme.typography.labelSmall,
            )

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = stringResource(Res.string.about_curator_1_name),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Text(
                        text = stringResource(Res.string.about_curator_2_name),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Text(
                        text = stringResource(Res.string.about_curator_3_name),
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
            contentDescription = stringResource(Res.string.about_section_icon_content_description),
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