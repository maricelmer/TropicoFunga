package br.com.monolit.tropicofunga.features.shared.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.monolit.tropicofunga.data.DataImage
import br.com.monolit.tropicofunga.features.shared.utils.toAnnotatedStringWithItalics
import br.com.monolit.tropicofunga.repository.impl.staticData.examplePhoto
import com.example.compose.AppTheme
import com.github.panpf.zoomimage.CoilZoomAsyncImage
import org.jetbrains.compose.resources.stringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.image_content_description
import tropicofunga.shared.generated.resources.photo_by_format

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageCarouselView(
    modifier: Modifier,
    openInImageIndex: Int,
    imagesPaths: List<DataImage>,
    onCloseRequest: () -> Unit,
) {
    val pageState = rememberPagerState(initialPage = openInImageIndex) { imagesPaths.size }

    val textShadow = Shadow(
        color = MaterialTheme.colorScheme.outlineVariant,
        offset = Offset(x = 4f, y = 4f),
        blurRadius = 2f,
    )
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onCloseRequest) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null,
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = Color.Transparent,
                )
            )
        },
    ) { paddingValues ->
        HorizontalPager(
            state = pageState
        ) { page ->
            val image = imagesPaths[page]
            Box(modifier = modifier) {
                CarouselImageView(
                    modifier = Modifier.fillMaxSize(),
                    image = image,
                )
                if (imagesPaths.size > 1) {
                    Text(
                        modifier = Modifier.align(Alignment.TopEnd)
                            .padding(paddingValues)
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        text = "${page + 1}/${imagesPaths.size}",
                        style = MaterialTheme.typography.labelSmall.copy(shadow = textShadow),
                        color = MaterialTheme.colorScheme.outline,
                    )
                }
                Column(
                    Modifier.align(Alignment.BottomStart)
                        .padding(paddingValues)
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                ) {
                    Text(
                        text = stringResource(image.legend).toAnnotatedStringWithItalics(),
                        style = MaterialTheme.typography.labelSmall.copy(shadow = textShadow),
                        color = MaterialTheme.colorScheme.outline,
                    )
                    image.author?.let { author ->
                        Text(
                            text = stringResource(Res.string.photo_by_format, author),
                            style = MaterialTheme.typography.labelSmall.copy(shadow = textShadow),
                            color = MaterialTheme.colorScheme.outline,
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun CarouselImageView(
    modifier: Modifier,
    image: DataImage,
) {
    var bytes by remember {
        mutableStateOf(ByteArray(0))
    }
    LaunchedEffect(Unit) {
        bytes = Res.readBytes(image.path)
    }

    CoilZoomAsyncImage(
        modifier = modifier,
        model = bytes,
        contentScale = ContentScale.Fit,
        alignment = Alignment.Center,
        contentDescription = stringResource(Res.string.image_content_description)
    )
}

@Preview
@Composable
private fun CarouselImagePreview() {
    AppTheme(darkTheme = false) {
        CarouselImageView(
            modifier = Modifier.fillMaxSize(),
            image = examplePhoto,
        )
    }
}
