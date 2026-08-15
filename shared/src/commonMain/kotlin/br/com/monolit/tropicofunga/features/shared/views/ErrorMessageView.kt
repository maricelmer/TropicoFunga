package br.com.monolit.tropicofunga.features.shared.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme

@Composable
fun ErrorMessageView(
    modifier: Modifier,
    message: String,
    showTrainAgain: Boolean = true,
    onTryAgainRequest: () -> Unit = {},
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(8.dp),
) {
    val contentColor = MaterialTheme.colorScheme.error
    Column(
        modifier = modifier,
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement,
    ) {
        Text(
            text = "Something went wrong", // TODO internationalize
            style = MaterialTheme.typography.bodyMedium,
            color = contentColor,
        )
        Icon(
            modifier = Modifier.size(48.dp),
            imageVector = Icons.Default.ErrorOutline,
            tint = contentColor,
            contentDescription = "Error Icon", // TODO internationalize
        )
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            color = contentColor,
        )
        if (showTrainAgain) {
            TextButton(onClick = onTryAgainRequest) {
                Text(
                    text = "Try Again", // TODO internationalize
                    style = MaterialTheme.typography.labelSmall,
                    color = contentColor
                )
            }
        }
    }
}

@Preview
@Composable
private fun ErrorMessagePreview() {
    AppTheme(darkTheme = false) {
        ErrorMessageView(
            modifier = Modifier.fillMaxWidth(),
            message = "An error occurred while processing your request.",
        )
    }
}