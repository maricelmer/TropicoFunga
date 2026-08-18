package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.monolit.tropicofunga.data.ectomycorrhiza.EctomycorrhizaItem
import br.com.monolit.tropicofunga.data.ectomycorrhiza.toItem
import br.com.monolit.tropicofunga.repository.impl.staticData.ectomycorrhizaeData
import coil3.compose.AsyncImage
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.stringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.ectomycorrhiza_image_content_description
import tropicofunga.shared.generated.resources.location_icon_content_description

@OptIn(InternalResourceApi::class)
@Composable
fun EctomycorrhizaItemView(
    modifier: Modifier,
    item: EctomycorrhizaItem,
    onClick: () -> Unit,
) {
    var bytes by remember {
        mutableStateOf(ByteArray(0))
    }
    LaunchedEffect(Unit) {
        item.image?.path?.let {
            bytes = Res.readBytes(it)
        }
    }

    ElevatedCard(
        modifier = modifier,
        onClick = onClick,
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                modifier = Modifier.size(128.dp),
                model = bytes,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                contentDescription = stringResource(Res.string.ectomycorrhiza_image_content_description)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                EctomycorrhizaTypeChipView(type = item.type)

                Text(
                    text = item.fungus,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.secondary,
                )
                Text(
                    text = item.host,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = stringResource(Res.string.location_icon_content_description),
                        tint = MaterialTheme.colorScheme.outline,
                    )
                    Text(
                        text = item.ecosystem,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.outline,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun EctomycorrhizaItemPreview() {
    AppTheme(darkTheme = false) {
        EctomycorrhizaItemView(
            modifier = Modifier.fillMaxWidth(),
            item = ectomycorrhizaeData.random().toItem(),
            onClick = {},
        )
    }
}