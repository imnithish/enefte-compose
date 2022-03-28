package com.imnstudios.enefte.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

 val DarkColorPalette = darkColors(
    primary = primary,
    secondary = secondary,
    error = danger,
    background = dark,
    onBackground = white,
    onSecondary = gray_light,
    secondaryVariant = success
)

private val LightColorPalette = lightColors(
/* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun EnefteTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: Colors? = null,
    content: @Composable () -> Unit
) {
    val appColors = colors ?: if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = appColors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}