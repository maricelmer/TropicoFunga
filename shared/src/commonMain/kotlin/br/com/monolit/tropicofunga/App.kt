package br.com.monolit.tropicofunga

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import br.com.monolit.tropicofunga.navigation.main.AppNavHost
import com.example.compose.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        AppNavHost(
            modifier = Modifier.fillMaxSize(),
            navHostController = rememberNavController(),
        )
    }
}