package br.com.monolit.tropicofunga.features.shared.views

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme


@Composable
fun EmailLinkText(
    email: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.labelSmall,
) {
    val annotatedString = buildAnnotatedString {
        withLink(
            link = LinkAnnotation.Url(
                url = "mailto:$email",
                styles = TextLinkStyles(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        textDecoration = TextDecoration.Underline
                    )
                )
            )
        ) {
            append(email)
        }
    }

    // Pass the annotated string directly to a normal Text composable
    Text(
        modifier = modifier,
        text = annotatedString,
        style = textStyle,
    )
}

@Preview
@Composable
private fun EmailLinkTextPreview() {
    AppTheme(darkTheme = false) {
        EmailLinkText("example@example.com.br")
    }
}