package br.com.monolit.tropicofunga.features.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme

@Composable
fun FeatureCardView(
    modifier: Modifier,
    title: String,
    icon: Painter,
    colors: CardColors = CardDefaults.cardColors(),
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier,
        onClick = onClick,
        colors = colors
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(
                4.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = icon,
                modifier = Modifier.size(48.dp),
                contentDescription = null,
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center,
                minLines = 2,
                maxLines = 2,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun FeatureCardViewPreview() {
    AppTheme {
        FeatureCardView(
            modifier = Modifier.size(112.dp),
            title = "Sobre",
            icon = rememberVectorPainter(Icons.Outlined.Info),
            onClick = {},
        )
    }
}