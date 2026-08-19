package br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.monolit.tropicofunga.data.host.Host
import br.com.monolit.tropicofunga.repository.impl.staticData.hostsData
import coil3.compose.AsyncImage
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.stringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.host_image_content_description

@OptIn(InternalResourceApi::class)
@Composable
fun HostItemView(
    modifier: Modifier,
    item: Host,
    onClick: () -> Unit,
) {
    var bytes by remember {
        mutableStateOf(ByteArray(0))
    }
    LaunchedEffect(Unit) {
        item.image?.let {
            bytes = Res.readBytes(it.path)
        }
    }

    ElevatedCard(
        modifier = modifier,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier.weight(1f),
                model = bytes,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                contentDescription = stringResource(Res.string.host_image_content_description)
            )

            Text(
                text = item.name,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
                minLines = 3,
                maxLines = 3,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
            )
        }
    }
}

@Preview
@Composable
private fun FungusItemPreview() {
    AppTheme(darkTheme = false) {
        HostItemView(
            modifier = Modifier.width(200.dp).height(300.dp),
            item = hostsData.random(),
            onClick = {}
        )
    }
}