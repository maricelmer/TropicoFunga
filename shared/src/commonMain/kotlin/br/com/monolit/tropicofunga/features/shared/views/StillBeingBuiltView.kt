package br.com.monolit.tropicofunga.features.shared.views

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.stringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.still_being_built_message

@Composable
fun StillBeingBuiltView(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = stringResource(Res.string.still_being_built_message),
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