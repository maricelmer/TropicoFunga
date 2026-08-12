package br.ufsc.micolab.tropicoecm

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.painterResource
import tropicoecm.shared.generated.resources.Res
import tropicoecm.shared.generated.resources.home_background

@Composable
@Preview
fun App() {
    AppTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.home_background),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopEnd,
                contentDescription = null,
            )
        }
    }
}