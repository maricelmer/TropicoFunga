package br.com.monolit.tropicofunga.features.atlasMycorrhizae.howToCollect.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme

@Composable
fun HowToCollectView(
    modifier: Modifier,
    onBackPressed: () -> Unit,
) {
    Scaffold(modifier = modifier) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            Text("How to collect")
            Button(onClick = onBackPressed) {
                Text("Back")
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