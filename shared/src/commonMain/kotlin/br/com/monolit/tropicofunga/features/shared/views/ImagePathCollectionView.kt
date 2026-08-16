package br.com.monolit.tropicofunga.features.shared.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.monolit.tropicofunga.repository.impl.staticData.examplePhoto
import coil3.compose.AsyncImage
import com.example.compose.AppTheme
import tropicofunga.shared.generated.resources.Res

@Composable
fun ImagePathCollectionView(
    modifier: Modifier,
    imagesPaths: List<br.com.monolit.tropicofunga.data.DataImage>,
    onViewImageRequest: (Int) -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        if (imagesPaths.isNotEmpty()) {
            ImagePathView(
                modifier = Modifier.weight(0.7f).fillMaxHeight(),
                imagePath = imagesPaths.first().path,
                onClick = { onViewImageRequest(0) }
            )
        }
        if (imagesPaths.size > 1) {
            Column(
                modifier = Modifier.weight(0.3f).fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                ImagePathView(
                    modifier = Modifier.fillMaxWidth().weight(0.5f),
                    imagePath = imagesPaths[1].path,
                    onClick = { onViewImageRequest(1) }
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f)
                        .clip(MaterialTheme.shapes.medium),
                ) {
                    if (imagesPaths.size > 2) {
                        ImagePathView(
                            modifier = Modifier.fillMaxSize(),
                            imagePath = imagesPaths[2].path,
                            onClick = { onViewImageRequest(2) }
                        )

                        if (imagesPaths.size > 3) {
                            val remaining = imagesPaths.size - 3
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(MaterialTheme.colorScheme.outlineVariant.copy(0.2f))
                                    .clickable(onClick = { onViewImageRequest(3) }),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "+$remaining",
                                    textAlign = TextAlign.Center,
                                    color = MaterialTheme.colorScheme.outline.copy(0.4f)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ImagePathCollectionPreview() {
    AppTheme(darkTheme = false) {
        ImagePathCollectionView(
            modifier = Modifier.fillMaxWidth().height(300.dp),
            imagesPaths = listOf(
                examplePhoto,
                examplePhoto,
                examplePhoto,
                examplePhoto
            ),
            onViewImageRequest = {}
        )
    }
}

@Composable
fun ImagePathView(
    modifier: Modifier,
    imagePath: String,
    onClick: () -> Unit,
) {
    var bytes by remember {
        mutableStateOf(ByteArray(0))
    }
    LaunchedEffect(Unit) {
        bytes = Res.readBytes(imagePath)
    }
    ElevatedCard(
        modifier = modifier,
        onClick = onClick
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = bytes,
            contentScale = ContentScale.Crop,
            contentDescription = "Image" // TODO internationalize
        )
    }
}

@Preview
@Composable
private fun ImagePathPreview() {
    AppTheme(darkTheme = false) {
        ImagePathView(
            modifier = Modifier.size(128.dp),
            imagePath = examplePhoto.path,
            onClick = {}
        )
    }
}