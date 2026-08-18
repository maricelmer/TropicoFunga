package br.com.monolit.tropicofunga.features.shared.views

import androidx.compose.animation.AnimatedContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.stringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.collapse_icon_content_description
import tropicofunga.shared.generated.resources.expand_icon_content_description

@Composable
fun ExpandOrCollapseIcon(
    modifier: Modifier,
    expanded: Boolean,
    tint: Color = MaterialTheme.colorScheme.outline
) {
    AnimatedContent(expanded) {
        if (it) {
            Icon(
                modifier = modifier,
                imageVector = Icons.Default.ExpandLess,
                tint = tint,
                contentDescription = stringResource(Res.string.collapse_icon_content_description)
            )
        } else {
            Icon(
                modifier = modifier,
                imageVector = Icons.Default.ExpandMore,
                tint = tint,
                contentDescription = stringResource(Res.string.expand_icon_content_description)
            )
        }
    }
}