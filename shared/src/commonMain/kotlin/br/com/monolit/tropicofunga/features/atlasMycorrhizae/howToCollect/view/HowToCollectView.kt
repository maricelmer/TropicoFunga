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
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.analyses_anatomical_studies_step_content
import tropicofunga.shared.generated.resources.analyses_molecular_studies_step_content
import tropicofunga.shared.generated.resources.ecm_icon
import tropicofunga.shared.generated.resources.eppendorf_icon
import tropicofunga.shared.generated.resources.field_collection_step_content
import tropicofunga.shared.generated.resources.laboratory_screening_step_content
import tropicofunga.shared.generated.resources.molecule_icon
import tropicofunga.shared.generated.resources.roots_icon
import tropicofunga.shared.generated.resources.shovel_icon

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
                title = "How to collect and identify".toAnnotatedString(), // TODO internationalize
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
                text = "Workflow for collection, sorting and analysis", // TODO internationalize
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )

            HowToCollectStepView(
                modifier = Modifier.fillMaxWidth(),
                step = 1,
                title = "Field Collection", // TODO internationalize
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
                                text = "Extract fine roots to a depth of 30 cm near the host plant or beneath basidiomata.", // TODO internationalize
                            )
                            HowToCollectStepSection(
                                text = "Collect as many lateral root tips (≤ 2 mm in diameter) as possible.", // TODO internationalize
                            )
                            HowToCollectStepSection(
                                text = "Carefully remove excess soil without damaging the roots.", // TODO internationalize
                            )
                        }
                        FieldCollectionStepImageContent()
                    }
                    HowToCollectStepRequiredMaterialsAndEquipment(
                        text = "shovel, zip-lock bags, refrigerator", // TODO internationalize,
                    )
                }
            }

            HowToCollectStepView(
                modifier = Modifier.fillMaxWidth(),
                step = 2,
                title = "Laboratory Screening", // TODO internationalize
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
                                text = "Wash the roots under running water, carefully separating the thin roots from the thick ones.", // TODO internationalize
                            )
                            HowToCollectStepSection(
                                text = "Examine the segments under a stereomicroscope, observing differences in thickness, color, and the presence of mycelium.", // TODO internationalize
                            )
                            HowToCollectStepSection(
                                text = "To confirm that it is an ectomycorrhiza, make a freehand section and observe under a microscope for the presence of a fungal mantle.", // TODO internationalize
                            )
                        }
                        LaboratoryScreeningStepImageContent()
                    }
                    HowToCollectStepRequiredMaterialsAndEquipment(
                        text = "1. trays, 2. forceps, 3. Petri dishes, 4. microscope slides and coverslips, 5. stereomicroscope, 6. optical microscope.", // TODO internationalize
                    )
                }
            }

            HowToCollectStepView(
                modifier = Modifier.fillMaxWidth(),
                step = 3,
                title = "Analyses", // TODO internationalize
                icon = painterResource(Res.drawable.molecule_icon)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = "Anatomical studies", // TODO internationalize
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
                                text = "Segment the roots and fix in 2.5% glutaraldehyde for 24 hours.", // TODO internationalize
                            )
                            HowToCollectStepSection(
                                text = "Wash the segments with sodium phosphate buffer and store in 70% ethanol.", // TODO internationalize
                            )
                            HowToCollectStepSection(
                                text = "Embed in historesin and cut sections using a microtome (3–10 µm thick).", // TODO internationalize
                            )
                        }

                        Column {
                            AnalysesAnatomicalStudiesStepImageContent()
                            HowToCollectStepRequiredMaterialsAndEquipment(
                                text = "1. Eppendorf tubes, 2. blocks, 3. microtome, 4. slides and coverslips, 5. optical microscope.", // TODO internationalize
                            )
                        }
                    }

                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    Text(
                        text = "Molecular studies", // TODO internationalize
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
                                text = "Separate root tips with ectomycorrhiza and store in 70% ethanol.", // TODO internationalize
                            )
                            HowToCollectStepSection(
                                text = "Follow the recommended protocol for each species.", // TODO internationalize
                            )
                        }

                        Column {
                            AnalysesMolecularStudiesStepImageContent()
                            HowToCollectStepRequiredMaterialsAndEquipment(
                                text = "1. Eppendorf tube, 2. micropipette, 3. electrophoresis tank, 4. thermal cycler...", // TODO internationalize
                            )
                        }
                    }
                }
            }

            Text(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                text = "Best Practices", // TODO internationalize
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )

            BestPracticeItem(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                icon = painterResource(Res.drawable.shovel_icon),
                title = "Proper collection", // TODO internationalize
                description = "Collect roots near the host or beneath basidiomata, down to a depth of 30 cm." // TODO internationalize
            )

            HorizontalDivider()

            BestPracticeItem(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                icon = rememberVectorPainter(Icons.Outlined.Thermostat),
                title = "Temperature", // TODO internationalize
                description = "Store between 4–10 °C and analyze within 7 days." // TODO internationalize
            )

            HorizontalDivider()

            BestPracticeItem(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                icon = painterResource(Res.drawable.roots_icon),
                title = "Careful handling", // TODO internationalize
                description = "Avoid damage to the tips and the external mycelium." // TODO internationalize
            )

            HorizontalDivider()

            BestPracticeItem(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                icon = rememberVectorPainter(Icons.Outlined.WaterDrop),
                title = "Sanitization", // TODO internationalize
                description = "Use running water to wash the roots; do not use detergent or brushes." // TODO internationalize
            )

            HorizontalDivider()

            BestPracticeItem(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                icon = painterResource(Res.drawable.eppendorf_icon),
                title = "Storage", // TODO internationalize
                description = "For subsequent analyses, use 70% ethanol." // TODO internationalize
            )

            HorizontalDivider()

            BestPracticeItem(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                icon = rememberVectorPainter(Icons.AutoMirrored.Outlined.TextSnippet),
                title = "Notes", // TODO internationalize
                description = "Record information on the location, host, date, and environmental conditions" // TODO internationalize
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
                    contentDescription = "Warning icon"
                )
                Text(
                    text = "IMPORTANT: Each step directly influences the quality of the identification. A sound collection and processing protocol ensures reliable and reproducible results.", // TODO internationalize
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
                    contentDescription = "Step $title icon", // TODO internationalize
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
        contentDescription = "Step icon",
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
            text = "Extract fine roots to a depth of 30 cm near the host plant or beneath basidiomata.", // TODO internationalize
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
            text = "Required materials and equipment:", // TODO internationalize
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
            contentDescription = "$title icon", // TODO internationalize
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
            title = "Proper collection", // TODO internationalize
            description = "Collect roots near the host or beneath basidiomata, down to a depth of 30 cm." // TODO internationalize
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
                    text = "Place in resealable plastic bags and store at a temperature between 4 and 10 °C until the time of analysis", // TODO internationalize
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 6.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Do not exceed 10 days", // TODO internationalize
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
            text = "Up to 30cm", // TODO internationalize
            style = MaterialTheme.typography.labelSmall,
            fontSize = 6.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )
        Image(
            modifier = Modifier.fillMaxSize().padding(end = 50.dp),
            painter = painterResource(Res.drawable.field_collection_step_content),
            contentDescription = "Field collection step content image" // TODO internationalize
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
        contentDescription = "Laboratory screening step content image" // TODO internationalize
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
        contentDescription = "Analyses anatomical studies step content image" // TODO internationalize
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
        contentDescription = "Analyses molecular studies step content image" // TODO internationalize
    )
}

@Preview
@Composable
private fun AnalysesMolecularStudiesStepImageContentPreview() {
    AppTheme(darkTheme = false) {
        AnalysesMolecularStudiesStepImageContent()
    }
}