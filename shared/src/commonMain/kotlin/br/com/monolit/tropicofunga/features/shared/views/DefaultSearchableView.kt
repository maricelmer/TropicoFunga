package br.com.monolit.tropicofunga.features.shared.views

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.filters_label
import tropicofunga.shared.generated.resources.selected_icon_content_description
import tropicofunga.shared.generated.resources.unselected_icon_content_description

@Composable
fun DefaultSearchableView(
    modifier: Modifier,
    searchQuery: String,
    placeholder: String,
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    showFiltersButton: Boolean = true,
    onQueryChanged: (String) -> Unit,
    onBackPressed: () -> Unit,
    onFilterPressed: () -> Unit = {},
    filters: LazyListScope.() -> Unit = {},
    content: @Composable () -> Unit,
) {
    DefaultScaffold(
        modifier = modifier,
        topBar = {
            DefaultSearchAppBar(
                query = searchQuery,
                placeholder = placeholder,
                onQueryChanged = onQueryChanged,
                onBackPressed = onBackPressed,
                showFiltersButton = showFiltersButton,
                onFilterPressed = onFilterPressed,
            )
        },
    ) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                Surface(
                    modifier = Modifier.width(300.dp).fillMaxHeight()
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 8.dp),
                    ) {
                        item {
                            Text(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                text = stringResource(Res.string.filters_label),
                                style = MaterialTheme.typography.headlineSmall,
                            )
                        }

                        filters()
                    }
                }
            },
            content = content
        )
    }
}

fun LazyListScope.filterSection(
    title: @Composable () -> String,
    expanded: Boolean,
    onClick: () -> Unit,
    content: LazyListScope.() -> Unit,
) {
    item {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title(),
                style = MaterialTheme.typography.labelSmall,
            )
            ExpandOrCollapseIcon(
                modifier = Modifier.size(18.dp),
                expanded = expanded
            )
        }
    }

    if (expanded) {
        content()
    }

    item {
        HorizontalDivider()
    }
}

fun LazyListScope.filterSelectableItem(
    title: AnnotatedString,
    selected: Boolean,
    onClick: () -> Unit,
) {
    item {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelSmall
            )
            AnimatedContent(selected) {
                if (it) {
                    Icon(
                        imageVector = Icons.Default.CheckBox,
                        modifier = Modifier.size(18.dp),
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = stringResource(Res.string.selected_icon_content_description)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.CheckBoxOutlineBlank,
                        modifier = Modifier.size(18.dp),
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = stringResource(Res.string.unselected_icon_content_description)
                    )
                }
            }
        }
    }
}