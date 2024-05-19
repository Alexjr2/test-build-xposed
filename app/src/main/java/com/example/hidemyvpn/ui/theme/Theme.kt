package com.example.hidemyvpn.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// Dark Theme
private val DarkColorPalette = darkColorScheme(
    primary = DarkBlue,
    secondary = DarkOrange,
    tertiary = LightBlue
)

// Light Theme
private val LightColorPalette = lightColorScheme(
    primary = BrightBlue,
    secondary = BrightOrange,
    tertiary = LightOrange,
)

@Composable
fun APPTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorPalette else LightColorPalette, content = content
    )
}