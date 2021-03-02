package pl.wmariusz.hedgehopt.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColors(
    primary = Brown500,
    primaryVariant = Brown700,
    onPrimary = Color.White,
    secondary = LightGreen200,
    secondaryVariant = LightGreen700,
    onSecondary = Color.Black
)

private val DarkColors = darkColors(
    primary = Brown200,
    primaryVariant = Brown700,
    onPrimary = Color.Black,
    secondary = LightGreen200,
    secondaryVariant = LightGreen700,
    onSecondary = Color.Black
)

@Composable
fun HedgehoptTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
        typography = HedgehoptTypography,
        content = content
    )
}