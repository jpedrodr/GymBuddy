package com.gymbuddy.gbcompose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

//Summary of Color Roles:
//Primary: The dominant color for your app, used for key interactive elements.
//OnPrimary: Text/icons on top of primary-colored elements.
//Secondary: Complementary accent color for secondary actions or items.
//OnSecondary: Text/icons on secondary-colored elements.
//Background: General background color of the screen or app.
//OnBackground: Text/icons on top of the background.
//Surface: Elements that sit on top of the background (cards, modals, etc.).
//OnSurface: Text/icons on top of surface elements.
//Error: Color for error states or critical issues.
//OnError: Text/icons on top of error-colored elements.

private val GymBuddyLightColorScheme = lightColorScheme(
    primary = Color(0xFFFF4C7A),
    onPrimary = Color.White,
    secondary = Color(0xFF4AE3D1),
    onSecondary = Color(0xFF1C1C1E),
    background = Color(0xFFFAFAFA),
    onBackground = Color(0xFF2F4858),
    surface = Color(0xFFF1F1F1),
    onSurface = Color(0xFF1C1C1E),
    error = Color(0xFFFF3B30)
)

private val GymBuddyDarkColorScheme = darkColorScheme(
    primary = Color(0xFFFF4C7A),
    onPrimary = Color.White,
    secondary = Color(0xFF4AE3D1),
    onSecondary = Color(0xFF1C1C1E),
    background = Color(0xFF2F4858),
    onBackground = Color(0xFFE0E0E0),
    surface = Color(0xFF2F4858),
    onSurface = Color(0xFFE0E0E0),
    error = Color(0xFFFF3B30)
)

@Composable
fun GymBuddyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> GymBuddyDarkColorScheme
        else -> GymBuddyLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = GymBuddyTypography,
        content = content
    )
}