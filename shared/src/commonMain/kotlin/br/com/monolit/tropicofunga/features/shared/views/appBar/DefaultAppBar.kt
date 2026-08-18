package br.com.monolit.tropicofunga.features.shared.views.appBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import br.com.monolit.tropicofunga.features.shared.utils.toAnnotatedString
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.stringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.back_button_content_description


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBar(
    title: AnnotatedString,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth(),
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.primary,
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(Res.string.back_button_content_description)
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DefaultAppBarPreview() {
    AppTheme(darkTheme = false) {
        DefaultAppBar(
            title = "Test App Bar".toAnnotatedString(),
            onBackPressed = {}
        )
    }
}