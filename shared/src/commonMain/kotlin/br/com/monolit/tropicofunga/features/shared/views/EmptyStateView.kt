package br.com.monolit.tropicofunga.features.shared.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.stringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.empty_state_icon_content_description
import tropicofunga.shared.generated.resources.no_results_found_message
import tropicofunga.shared.generated.resources.no_results_found_title

/**
 * Shown when a search/filter successfully resolves to an empty list — as opposed to
 * [ErrorMessageView] (a failed load) or [LoadView] (loading in progress).
 */
@Composable
fun EmptyStateView(
    modifier: Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(8.dp),
) {
    val contentColor = MaterialTheme.colorScheme.outline
    Column(
        modifier = modifier,
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement,
    ) {
        Icon(
            modifier = Modifier.size(48.dp),
            imageVector = Icons.Default.SearchOff,
            tint = contentColor,
            contentDescription = stringResource(Res.string.empty_state_icon_content_description),
        )
        Text(
            text = stringResource(Res.string.no_results_found_title),
            style = MaterialTheme.typography.bodyMedium,
            color = contentColor,
            textAlign = TextAlign.Center,
        )
        Text(
            text = stringResource(Res.string.no_results_found_message),
            style = MaterialTheme.typography.bodySmall,
            color = contentColor,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
private fun EmptyStatePreview() {
    AppTheme(darkTheme = false) {
        EmptyStateView(
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
