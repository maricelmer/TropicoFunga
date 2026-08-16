package br.com.monolit.tropicofunga.features.shared.views

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.features.shared.views.appBar.DefaultAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultDetailsView(
    modifier: Modifier,
    title: String,
    onBackPressed: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
) {
    DefaultScaffold(
        modifier = modifier,
        topBar = {
            DefaultAppBar(
                title = title,
                onBackPressed = onBackPressed,
            )
        },
        content = content
    )
}