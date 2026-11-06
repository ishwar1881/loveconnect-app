package com.loveconnect.app.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val RedPrimary = Color(0xFFB8142A)
val RedSoft = Color(0xFFFF5075)
val RedDeep = Color(0xFF5C0618)
val Black = Color(0xFF050505)
val Slate = Color(0xFF101114)
val CardDark = Color(0xFF16181D)
val MutedWhite = Color(0xFFEAEAEA)
val SoftGray = Color(0xFF999BA3)
val SuccessGreen = Color(0xFF2ED98A)
val WarningAmber = Color(0xFFFFC857)

private val DarkColorScheme = darkColorScheme(
    primary = RedPrimary,
    onPrimary = MutedWhite,
    primaryContainer = RedDeep,
    secondary = RedSoft,
    background = Black,
    surface = CardDark,
    onBackground = MutedWhite,
    onSurface = MutedWhite,
    error = RedSoft,
    tertiary = SuccessGreen,
)

@Composable
fun LoveConnectTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content,
    )
}
