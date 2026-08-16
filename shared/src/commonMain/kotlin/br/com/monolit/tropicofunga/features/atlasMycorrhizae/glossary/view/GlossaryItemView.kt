package br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.monolit.tropicofunga.data.glossary.GlossaryEntry
import br.com.monolit.tropicofunga.repository.impl.staticData.glossaryData
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.stringResource

@OptIn(InternalResourceApi::class)
@Composable
fun GlossaryItemView(
    modifier: Modifier,
    item: GlossaryEntry,
) {
    ElevatedCard(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = stringResource(item.term),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text = stringResource(item.definition),
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview
@Composable
private fun GlossaryItemPreview() {
    AppTheme(darkTheme = false) {
        GlossaryItemView(
            modifier = Modifier.fillMaxWidth(),
            item = glossaryData.random(),
        )
    }
}