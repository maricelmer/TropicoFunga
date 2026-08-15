package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.ectomycorrhiza.EctomycorrhizaType
import br.com.monolit.tropicofunga.features.shared.views.getColorFromText
import br.com.monolit.tropicofunga.repository.impl.staticData.ectomycorrhizaTypesData
import com.example.compose.AppTheme

@Composable
fun EctomycorrhizaTypeChipView(
    type: EctomycorrhizaType,
    modifier: Modifier = Modifier,
) {
    val color = getColorFromText(type.name)
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = color.copy(0.2f),
            contentColor = color,
        ),
        shape = MaterialTheme.shapes.small,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            text = type.name,
            style = MaterialTheme.typography.labelSmall,
        )
    }
}

@Preview
@Composable
private fun EctomycorrhizaTypeChipPreview() {
    AppTheme(darkTheme = false) {
        EctomycorrhizaTypeChipView(
            modifier = Modifier,
            type = ectomycorrhizaTypesData.random()
        )
    }
}

