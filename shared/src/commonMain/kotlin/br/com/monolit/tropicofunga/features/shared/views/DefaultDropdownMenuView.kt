package br.com.monolit.tropicofunga.features.shared.views

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme

@Composable
fun <T> DefaultDropdownMenuView(
    items: List<T>,
    selectedItem: T,
    onItemSelected: (T) -> Unit,
    labelMaker: (T) -> String = { it.toString() },
    itemLabelMaker: (T) -> String = { it.toString() },
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(8.dp, Alignment.Start),
    modifier: Modifier = Modifier,
) {
    var isExpanded by remember { mutableStateOf(false) }
    Box(
        modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = MaterialTheme.shapes.small
            )
            .clickable(onClick = { isExpanded = !isExpanded })
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = horizontalArrangement,
        ) {
            Text(
                text = labelMaker(selectedItem),
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
            )
            ExpandOrCollapseIcon(
                modifier = Modifier.size(18.dp),
                expanded = isExpanded
            )
        }
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            items.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = itemLabelMaker(option),
                            style = MaterialTheme.typography.labelSmall,
                            maxLines = 1,
                        )
                    },
                    onClick = {
                        onItemSelected(option)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun DefaultDropdownMenuPreview() {
    val options = listOf("Option 1", "Option 2", "Option 3")
    var selectedOption by remember { mutableStateOf(options.first()) }
    AppTheme(darkTheme = false) {
        DefaultDropdownMenuView(
            items = options,
            selectedItem = selectedOption,
            onItemSelected = { selectedOption = it }
        )
    }
}