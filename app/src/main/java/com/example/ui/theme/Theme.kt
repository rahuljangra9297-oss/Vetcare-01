package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val VetCareLightColorScheme = lightColorScheme(
    primary = MedicalCyanPrimary,
    onPrimary = Color.White,
    primaryContainer = MedicalCyanLight,
    onPrimaryContainer = MedicalCyanDark,
    secondary = AgroEmeraldPrimary,
    onSecondary = Color.White,
    secondaryContainer = AgroEmeraldLight,
    onSecondaryContainer = AgroEmeraldDark,
    tertiary = RoyalIndigoPrimary,
    onTertiary = Color.White,
    tertiaryContainer = RoyalIndigoLight,
    onTertiaryContainer = RoyalIndigoDark,
    background = DaylightCanvas,
    onBackground = Slate900,
    surface = DaylightSurface,
    onSurface = Slate900,
    surfaceVariant = DaylightSurface,
    onSurfaceVariant = Slate900,
    error = RedAlert,
    onError = Color.White,
    errorContainer = RedAlertLight,
    onErrorContainer = RedAlert,
    outline = FrostedCardBorder
)

@Composable
fun MyApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = VetCareLightColorScheme,
        typography = Typography,
        content = content
    )
}
