package com.imnstudios.enefte.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.imnstudios.enefte.R


private val light = Font(R.font.gilroy_light, FontWeight.W300)
private val regular = Font(R.font.gilroy_regular, FontWeight.W300)
private val medium = Font(R.font.gilroy_medium, FontWeight.W400)
private val semi_bold = Font(R.font.gilroy_semibold, FontWeight.W600)
private val fontFamily = FontFamily(fonts = listOf(regular, medium, semi_bold))


// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = fontFamily,
    h1 = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 31.sp,
        color = white
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 24.sp,
        color = white
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        color = white
    ),
    button = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
        color = white
    ),
    caption = TextStyle(
        fontWeight = FontWeight.W300,
        fontSize = 12.sp,
        color = white
    ),
    overline = TextStyle(
        fontWeight = FontWeight.W300,
        fontSize = 10.sp,
        color = gray_light
    ),
)