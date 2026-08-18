package br.com.monolit.tropicofunga.features.atlasMycorrhizae.howToCollect.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.automirrored.outlined.TextSnippet
import androidx.compose.material.icons.filled.Biotech
import androidx.compose.material.icons.outlined.Thermostat
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material.icons.outlined.WaterDrop
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.monolit.tropicofunga.features.shared.utils.toAnnotatedString
import br.com.monolit.tropicofunga.features.shared.views.DefaultScaffold
import br.com.monolit.tropicofunga.features.shared.views.appBar.DefaultAppBar
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.analyses_anatomical_studies_step_content
import tropicofunga.shared.generated.resources.analyses_anatomical_studies_step_image_content_description
import tropicofunga.shared.generated.resources.analyses_molecular_studies_step_content
import tropicofunga.shared.generated.resources.analyses_molecular_studies_step_image_content_description
import tropicofunga.shared.generated.resources.analyses_step_title
import tropicofunga.shared.generated.resources.anatomical_studies_required_materials
import tropicofunga.shared.generated.resources.anatomical_studies_step_1_text
import tropicofunga.shared.generated.resources.anatomical_studies_step_2_text
import tropicofunga.shared.generated.resources.anatomical_studies_step_3_text
import tropicofunga.shared.generated.resources.anatomical_studies_subtitle
import tropicofunga.shared.generated.resources.best_practice_collection_description
import tropicofunga.shared.generated.resources.best_practice_collection_title
import tropicofunga.shared.generated.resources.best_practice_handling_description
import tropicofunga.shared.generated.resources.best_practice_handling_title
import tropicofunga.shared.generated.resources.best_practice_icon_content_description_format
import tropicofunga.shared.generated.resources.best_practice_notes_description
import tropicofunga.shared.generated.resources.best_practice_notes_title
import tropicofunga.shared.generated.resources.best_practice_sanitization_description
import tropicofunga.shared.generated.resources.best_practice_sanitization_title
import tropicofunga.shared.generated.resources.best_practice_storage_description
import tropicofunga.shared.generated.resources.best_practice_storage_title
import tropicofunga.shared.generated.resources.best_practice_temperature_description
import tropicofunga.shared.generated.resources.best_practice_temperature_title
import tropicofunga.shared.generated.resources.best_practices_title
import tropicofunga.shared.generated.resources.ecm_icon
import tropicofunga.shared.generated.resources.eppendorf_icon
import tropicofunga.shared.generated.resources.field_collection_bag_days_note_text
import tropicofunga.shared.generated.resources.field_collection_bag_note_text
import tropicofunga.shared.generated.resources.field_collection_depth_label
import tropicofunga.shared.generated.resources.field_collection_required_materials
import tropicofunga.shared.generated.resources.field_collection_step_content
import tropicofunga.shared.generated.resources.field_collection_step_image_content_description
import tropicofunga.shared.generated.resources.field_collection_step_1_text
import tropicofunga.shared.generated.resources.field_collection_step_2_text
import tropicofunga.shared.generated.resources.field_collection_step_3_text
import tropicofunga.shared.generated.resources.field_collection_step_title
import tropicofunga.shared.generated.resources.how_to_collect_and_identify_title
import tropicofunga.shared.generated.resources.important_note_text
import tropicofunga.shared.generated.resources.laboratory_screening_required_materials
import tropicofunga.shared.generated.resources.laboratory_screening_step_1_text
import tropicofunga.shared.generated.resources.laboratory_screening_step_2_text
import tropicofunga.shared.generated.resources.laboratory_screening_step_3_text
import tropicofunga.shared.generated.resources.laboratory_screening_step_content
import tropicofunga.shared.generated.resources.laboratory_screening_step_image_content_description
import tropicofunga.shared.generated.resources.laboratory_screening_step_title
import tropicofunga.shared.generated.resources.molecular_studies_required_materials
import tropicofunga.shared.generated.resources.molecular_studies_step_1_text
import tropicofunga.shared.generated.resources.molecular_studies_step_2_text
import tropicofunga.shared.generated.resources.molecular_studies_subtitle
import tropicofunga.shared.generated.resources.molecule_icon
import tropicofunga.shared.generated.resources.required_materials_and_equipment_label
import tropicofunga.shared.generated.resources.roots_icon
import tropicofunga.shared.generated.resources.shovel_icon
import tropicofunga.shared.generated.resources.step_bullet_icon_content_description
import tropicofunga.shared.generated.resources.step_icon_content_description_format
import tropicofunga.shared.generated.resources.warning_icon_content_description
import tropicofunga.shared.generated.resources.workflow_title

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HowToCollectView(
    modifier: Modifier,
    onBackPressed: () -> Unit,
) {
    val scrollState = rememberScrollState()
    DefaultScaffold(
        modifier = modifier,
        topBar = {
            DefaultAppBar(
                title = stringResource(Res.string.how_to_collect_and_identify_title).toAnnotatedString(),
                onBackPressed = onBackPressed,
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                text = stringResource(Res.string.workflow_title),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )

            HowToCollectStepView(
                modifier = Modifier.fillMaxWidth(),
                step = 1,
                title = stringResource(Res.string.field_collection_step_title),
                icon = painterResource(Res.drawable.ecm_icon)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        itemVerticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            modifier = Modifier.widthIn(min = 200.dp).weight(1f),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            HowToCollectStepSection(
                                text = stringResource(Res.string.field_collection_step_1_text),
                            )
                            HowToCollectStepSection(
                                text = stringResource(Res.string.field_collection_step_2_text),
                            )
                            HowToCollectStepSection(
                                text = stringResource(Res.string.field_collection_step_3_text),
                            )
                        }
                        FieldCollectionStepImageContent()
                    }
                    HowToCollectStepRequiredMaterialsAndEquipment(
                        text = stringResource(Res.string.field_collection_required_materials),
                    )
                }
            }

            HowToCollectStepView(
                modifier = Modifier.fillMaxWidth(),
                step = 2,
                title = stringResource(Res.string.laboratory_screening_step_title),
                icon = rememberVectorPainter(Icons.Default.Biotech)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        itemVerticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            modifier = Modifier.widthIn(min = 200.dp).weight(1f),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            HowToCollectStepSection(
                                text = stringResource(Res.string.laboratory_screening_step_1_text),
                            )
                            HowToCollectStepSection(
                                text = stringResource(Res.string.laboratory_screening_step_2_text),
                            )
                            HowToCollectStepSection(
                                text = stringResource(Res.string.laboratory_screening_step_3_text),
                            )
                        }
                        LaboratoryScreeningStepImageContent()
                    }
                    HowToCollectStepRequiredMaterialsAndEquipment(
                        text = stringResource(Res.string.laboratory_screening_required_materials),
                    )
                }
            }

            HowToCollectStepView(
                modifier = Modifier.fillMaxWidth(),
                step = 3,
                title = stringResource(Res.string.analyses_step_title),
                icon = painterResource(Res.drawable.molecule_icon)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = stringResource(Res.string.anatomical_studies_subtitle),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                    )

                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        itemVerticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            modifier = Modifier.widthIn(min = 200.dp).weight(1f),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            HowToCollectStepSection(
                                text = stringResource(Res.string.anatomical_studies_step_1_text),
                            )
                            HowToCollectStepSection(
                                text = stringResource(Res.string.anatomical_studies_step_2_text),
                            )
                            HowToCollectStepSection(
                                text = stringResource(Res.string.anatomical_studies_step_3_text),
                            )
                        }

                        Column {
                            AnalysesAnatomicalStudiesStepImageContent()
                            HowToCollectStepRequiredMaterialsAndEquipment(
                                text = stringResource(Res.string.anatomical_studies_required_materials),
                            )
                        }
                    }

                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    Text(
                        text = stringResource(Res.string.molecular_studies_subtitle),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                    )

                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        itemVerticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            modifier = Modifier.widthIn(min = 200.dp).weight(1f),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            HowToCollectStepSection(
                                text = stringResource(Res.string.molecular_studies_step_1_text),
                            )
                            HowToCollectStepSection(
                                text = stringResource(Res.string.molecular_studies_step_2_text),
                            )
                        }

                        Column {
                            AnalysesMolecularStudiesStepImageContent()
                            HowToCollectStepRequiredMaterialsAndEquipment(
                                text = stringResource(Res.string.molecular_studies_required_materials),
                            )
                        }
                    }
                }
            }

            Text(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                text = stringResource(Res.string.best_practices_title),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )

            BestPracticeItem(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                icon = painterResource(Res.drawable.shovel_icon),
                title = stringResource(Res.string.best_practice_collection_title),
                description = stringResource(Res.string.best_practice_collection_description)
            )

            HorizontalDivider()

            BestPracticeItem(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                icon = rememberVectorPainter(Icons.Outlined.Thermostat),
                title = stringResource(Res.string.best_practice_temperature_title),
                description = stringResource(Res.string.best_practice_temperature_description)
            )

            HorizontalDivider()

            BestPracticeItem(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                icon = painterResource(Res.drawable.roots_icon),
                title = stringResource(Res.string.best_practice_handling_title),
                description = stringResource(Res.string.best_practice_handling_description)
            )

            HorizontalDivider()

            BestPracticeItem(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                icon = rememberVectorPainter(Icons.Outlined.WaterDrop),
                title = stringResource(Res.string.best_practice_sanitization_title),
                description = stringResource(Res.string.best_practice_sanitization_description)
            )

            HorizontalDivider()

            BestPracticeItem(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                icon = painterResource(Res.drawable.eppendorf_icon),
                title = stringResource(Res.string.best_practice_storage_title),
                description = stringResource(Res.string.best_practice_storage_description)
            )

            HorizontalDivider()

            BestPracticeItem(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                icon = rememberVectorPainter(Icons.AutoMirrored.Outlined.TextSnippet),
                title = stringResource(Res.string.best_practice_notes_title),
                description = stringResource(Res.string.best_practice_notes_description)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .border(1.dp, color = MaterialTheme.colorScheme.primary)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Warning,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = stringResource(Res.string.warning_icon_content_description)
                )
                Text(
                    text = stringResource(Res.string.important_note_text),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun HowToCollectPreview() {
    AppTheme {
        HowToCollectView(
            modifier = Modifier.fillMaxSize(),
            onBackPressed = {},
        )
    }
}

@Composable
fun HowToCollectStepView(
    modifier: Modifier,
    step: Int,
    title: String,
    icon: Painter,
    content: @Composable () -> Unit
) {
    ElevatedCard(
        modifier = modifier,
    ) {
        Row(
            modifier = modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.width(64.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer.copy(0.5f)),
                    text = "$step",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                )
                Icon(
                    modifier = Modifier.size(48.dp),
                    painter = icon,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = stringResource(Res.string.step_icon_content_description_format, title),
                )
            }
            content()
        }
    }
}

@Preview
@Composable
private fun HowToCollectStepPreview() {
    AppTheme(darkTheme = false) {
        HowToCollectStepView(
            modifier = Modifier.fillMaxWidth(),
            step = 1,
            title = "Step 1",
            icon = painterResource(Res.drawable.ecm_icon)
        ) {
            HowToCollectStepIcon()
        }
    }
}

@Composable
fun HowToCollectStepIcon() {
    Icon(
        modifier = Modifier.size(18.dp),
        imageVector = Icons.AutoMirrored.Filled.Send,
        contentDescription = stringResource(Res.string.step_bullet_icon_content_description),
        tint = MaterialTheme.colorScheme.primary,
    )
}

@Preview
@Composable
private fun HowToCollectStepIconPreview() {
    AppTheme(darkTheme = false) {
        HowToCollectStepIcon()
    }
}

@Composable
fun HowToCollectStepSection(
    text: String,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        HowToCollectStepIcon()
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview
@Composable
private fun HowToCollectStepSectionPreview() {
    AppTheme(darkTheme = false) {
        HowToCollectStepSection(
            text = "Extract fine roots to a depth of 30 cm near the host plant or beneath basidiomata.",
        )
    }
}

@Composable
fun HowToCollectStepRequiredMaterialsAndEquipment(
    text: String,
) {
    FlowRow(
        itemVerticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = stringResource(Res.string.required_materials_and_equipment_label),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
        )
    }
}

@Preview
@Composable
private fun HowToCollectStepRequiredMaterialsAndEquipmentPreview() {
    AppTheme(darkTheme = false) {
        HowToCollectStepRequiredMaterialsAndEquipment(
            text = "1. trays, 2. forceps, 3. Petri dishes, 4. microscope slides and coverslips, 5. stereomicroscope, 6. optical microscope."
        )
    }
}

@Composable
fun BestPracticeItem(
    modifier: Modifier,
    icon: Painter,
    title: String,
    description: String,
) {
    val contentColor = MaterialTheme.colorScheme.primary
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            modifier = Modifier
                .size(48.dp)
                .border(width = 1.dp, color = contentColor, shape = CircleShape)
                .padding(8.dp),
            painter = icon,
            contentDescription = stringResource(Res.string.best_practice_icon_content_description_format, title),
            tint = contentColor,
        )
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelSmall,
                color = contentColor
            )
            Text(
                text = description,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Preview
@Composable
private fun BestPracticeItemPreview() {
    AppTheme(darkTheme = false) {
        BestPracticeItem(
            modifier = Modifier,
            icon = painterResource(Res.drawable.shovel_icon),
            title = "Proper collection",
            description = "Collect roots near the host or beneath basidiomata, down to a depth of 30 cm."
        )
    }
}

@Composable
fun FieldCollectionStepImageContent() {
    Box(
        modifier = Modifier.width(350.dp).height(200.dp),
    ) {
        Card(
            modifier = Modifier.align(Alignment.BottomEnd).width(90.dp)
        ) {
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(Res.string.field_collection_bag_note_text),
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 6.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(Res.string.field_collection_bag_days_note_text),
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 6.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        Text(
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(bottom = 35.dp, start = 35.dp),
            text = stringResource(Res.string.field_collection_depth_label),
            style = MaterialTheme.typography.labelSmall,
            fontSize = 6.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )
        Image(
            modifier = Modifier.fillMaxSize().padding(end = 50.dp),
            painter = painterResource(Res.drawable.field_collection_step_content),
            contentDescription = stringResource(Res.string.field_collection_step_image_content_description)
        )
    }
}

@Preview
@Composable
private fun FieldCollectionStepImageContentPreview() {
    AppTheme(darkTheme = false) {
        FieldCollectionStepImageContent()
    }
}

@Composable
fun LaboratoryScreeningStepImageContent() {
    Image(
        modifier = Modifier.width(350.dp).height(300.dp),
        painter = painterResource(Res.drawable.laboratory_screening_step_content),
        contentDescription = stringResource(Res.string.laboratory_screening_step_image_content_description)
    )
}

@Preview
@Composable
private fun LaboratoryScreeningStepImageContentPreview() {
    AppTheme(darkTheme = false) {
        LaboratoryScreeningStepImageContent()
    }
}

@Composable
fun AnalysesAnatomicalStudiesStepImageContent() {
    Image(
        modifier = Modifier.width(350.dp).height(300.dp),
        painter = painterResource(Res.drawable.analyses_anatomical_studies_step_content),
        contentDescription = stringResource(Res.string.analyses_anatomical_studies_step_image_content_description)
    )
}

@Preview
@Composable
private fun AnalysesAnatomicalStudiesStepImageContentPreview() {
    AppTheme(darkTheme = false) {
        AnalysesAnatomicalStudiesStepImageContent()
    }
}

@Composable
fun AnalysesMolecularStudiesStepImageContent() {
    Image(
        modifier = Modifier.width(350.dp).height(200.dp),
        painter = painterResource(Res.drawable.analyses_molecular_studies_step_content),
        contentDescription = stringResource(Res.string.analyses_molecular_studies_step_image_content_description)
    )
}

@Preview
@Composable
private fun AnalysesMolecularStudiesStepImageContentPreview() {
    AppTheme(darkTheme = false) {
        AnalysesMolecularStudiesStepImageContent()
    }
}
