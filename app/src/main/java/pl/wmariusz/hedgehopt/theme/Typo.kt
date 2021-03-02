package pl.wmariusz.hedgehopt.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import pl.wmariusz.hedgehopt.R

private val Montserrat = FontFamily(
    Font(R.font.montserrat)
)

val HedgehoptTypography = Typography(
    defaultFontFamily = Montserrat
)