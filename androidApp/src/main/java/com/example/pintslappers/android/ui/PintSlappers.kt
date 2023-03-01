package com.example.pintslappers.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import com.example.pintslappers.android.ui.*

private val DarkColorPalette = darkColorScheme(
    primary = DarkMustard,
    surface = DarkCharcoal,
    surfaceVariant = DarkOnyx,
    background = DarkIvory,
    secondary = DarkEbony,
    onSecondary = DarkAmber,
    tertiary = DarkSnow,
    onTertiary = DarkInvertedCharcoal,
    onPrimary = DarkInvertedMustard,
    onSurface = DarkSlate,
    inverseSurface = DarkTertiaryContent,
    inversePrimary = DarkAlabaster,
    onSurfaceVariant = DarkInvertedFrost,
    onTertiaryContainer = DarkBlizzard,
)

private val LightColorPalette = darkColorScheme(
    primary = LightMustard,
    surface = LightFrost,
    surfaceVariant = LightAlabaster,
    background = LightJet,
    secondary = LightBlizzard,
    onSecondary = LightGold,
    tertiary = LightObsidian,
    onTertiary = LightInvertedFrost,
    onPrimary = LightInvertedMustard,
    onSurface = LightPearl,
    inverseSurface = LightTertiaryContent,
    inversePrimary = LightJet,
    onSurfaceVariant = LightInvertedFrost,
    onTertiaryContainer = LightPearl,
)

@Composable
fun PintSlappersTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
