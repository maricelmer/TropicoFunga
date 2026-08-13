package br.com.monolit.tropicofunga.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import tropicofunga.shared.generated.resources.Inter
import tropicofunga.shared.generated.resources.Playfair_Display
import tropicofunga.shared.generated.resources.Res

// Default Material 3 typography values

@Composable
fun getAppTypography(): Typography {
    val bodyFontFamily = FontFamily(
        Font(resource = Res.font.Inter, weight = FontWeight.Normal),
        Font(resource = Res.font.Inter, weight = FontWeight.Medium),
        Font(resource = Res.font.Inter, weight = FontWeight.Bold),
    )
    val displayFontFamily = FontFamily(
        Font(resource = Res.font.Playfair_Display, weight = FontWeight.Normal),
        Font(resource = Res.font.Playfair_Display, weight = FontWeight.Medium),
        Font(resource = Res.font.Playfair_Display, weight = FontWeight.Bold),
    )
    val baseline = Typography()
    return Typography(
        displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily),
        displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily),
        displaySmall = baseline.displaySmall.copy(fontFamily = displayFontFamily),
        headlineLarge = baseline.headlineLarge.copy(fontFamily = displayFontFamily),
        headlineMedium = baseline.headlineMedium.copy(fontFamily = displayFontFamily),
        headlineSmall = baseline.headlineSmall.copy(fontFamily = displayFontFamily),
        titleLarge = baseline.titleLarge.copy(fontFamily = displayFontFamily),
        titleMedium = baseline.titleMedium.copy(fontFamily = displayFontFamily),
        titleSmall = baseline.titleSmall.copy(fontFamily = displayFontFamily),
        bodyLarge = baseline.bodyLarge.copy(fontFamily = bodyFontFamily),
        bodyMedium = baseline.bodyMedium.copy(fontFamily = bodyFontFamily),
        bodySmall = baseline.bodySmall.copy(fontFamily = bodyFontFamily),
        labelLarge = baseline.labelLarge.copy(fontFamily = bodyFontFamily),
        labelMedium = baseline.labelMedium.copy(fontFamily = bodyFontFamily),
        labelSmall = baseline.labelSmall.copy(fontFamily = bodyFontFamily),
    )
}
