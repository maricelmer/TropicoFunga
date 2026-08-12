package br.ufsc.micolab.tropicoecm

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import br.ufsc.micolab.tropicoecm.navigation.main.AppNavHost
import com.example.compose.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        AppNavHost(
            modifier = Modifier.fillMaxSize(),
            navHostController = rememberNavController()
        )
    }
}