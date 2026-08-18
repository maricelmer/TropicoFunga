package br.com.monolit.tropicofunga.features.shared.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberSearchBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.stringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.back_button_content_description
import tropicofunga.shared.generated.resources.clear_field_button_content_description
import tropicofunga.shared.generated.resources.filter_button_content_description
import tropicofunga.shared.generated.resources.search_icon_content_description

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultSearchAppBar(
    query: String,
    placeholder: String,
    onQueryChanged: (String) -> Unit,
    onBackPressed: () -> Unit,
    showFiltersButton: Boolean = true,
    onFilterPressed: () -> Unit = {},
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    TopAppBar(
        modifier = modifier,
        title = {
            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                state = rememberSearchBarState(),
                inputField = {
                    TextField(
                        value = query,
                        onValueChange = onQueryChanged,
                        textStyle = MaterialTheme.typography.labelMedium,
                        placeholder = {
                            Text(
                                text = placeholder,
                                style = MaterialTheme.typography.labelMedium,
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = stringResource(Res.string.search_icon_content_description)
                            )
                        },
                        trailingIcon = {
                            if (query.isNotBlank()) {
                                IconButton(
                                    onClick = {
                                        onQueryChanged("")
                                    },
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Clear,
                                        contentDescription = stringResource(Res.string.clear_field_button_content_description),
                                    )
                                }
                            }
                        }
                    )
                }
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(Res.string.back_button_content_description)
                )
            }
        },
        actions = {
            if (showFiltersButton) {
                IconButton(onClick = onFilterPressed) {
                    Icon(
                        imageVector = Icons.Default.Tune,
                        contentDescription = stringResource(Res.string.filter_button_content_description)
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultSearchAppBarPreview() {
    AppTheme(darkTheme = false) {
        Column {
            DefaultSearchAppBar(
                query = "",
                placeholder = "Search",
                onQueryChanged = {},
                onBackPressed = {},
                onFilterPressed = {},
            )
            DefaultSearchAppBar(
                query = "Test",
                placeholder = "Search",
                onQueryChanged = {},
                onBackPressed = {},
                onFilterPressed = {},
            )
        }
    }
}