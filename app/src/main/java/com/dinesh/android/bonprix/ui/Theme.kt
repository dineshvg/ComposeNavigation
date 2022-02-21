package com.dinesh.android.bonprix.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.dinesh.android.compose_ui.theme.Red200
import com.dinesh.android.compose_ui.theme.Red300
import com.dinesh.android.compose_ui.theme.Red700
import com.dinesh.android.compose_ui.theme.Red800
import com.dinesh.android.compose_ui.theme.Red900
import com.dinesh.android.compose_ui.theme.BonPrixTypography
import com.dinesh.android.compose_ui.theme.Shapes


private val LightThemeColors = lightColors(
    primary = Red700,
    primaryVariant = Red900,
    onPrimary = Color.White,
    secondary = Red700,
    secondaryVariant = Red900,
    onSecondary = Color.White,
    error = Red800,
    onBackground = Color.Black,
)

private val DarkThemeColors = darkColors(
    primary = Red300,
    primaryVariant = Red700,
    onPrimary = Color.Black,
    secondary = Red300,
    onSecondary = Color.Black,
    error = Red200,
    onBackground = Color.White
)

@Composable
fun BonPrixTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = BonPrixTypography,
        shapes = Shapes,
        content = content
    )
}