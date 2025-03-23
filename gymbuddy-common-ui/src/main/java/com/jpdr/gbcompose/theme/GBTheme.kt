package com.jpdr.gbcompose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val GymBuddyDarkColorScheme = darkColorScheme(
    primary = DarkOrangePrimary,
    onPrimary = Color.Black,
    secondary = DarkGreenSecondary,
    onSecondary = Color.Black,
    background = DarkBackground,
    onBackground = LightText,
    surface = DarkSurface,
    onSurface = LightText,
    outline = MediumGrayText
)

private val GymBuddyLightColorScheme = lightColorScheme(
    primary = OrangePrimary,
    onPrimary = Color.White,
    secondary = GreenSecondary,
    onSecondary = Color.White,
    background = LightBackground,
    onBackground = DarkText,
    surface = LightSurface,
    onSurface = DarkText,
    outline = GrayText // Used for dividers, borders, etc.
)

@Composable
fun GymBuddyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> GymBuddyDarkColorScheme
        else -> GymBuddyLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = GBTypography,
        content = content
    )
}