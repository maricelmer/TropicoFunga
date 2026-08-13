package br.com.monolit.tropicofunga.features.shared.views

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme

@Composable
fun StillBeingBuiltView(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "Still being built...",
        style = MaterialTheme.typography.bodyMedium
    )
}

@Preview(showBackground = true)
@Composable
private fun StillBeingBuiltView() {
    AppTheme(darkTheme = false) {
        StillBeingBuiltView()
    }
}