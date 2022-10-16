package com.example.thenews.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thenews.R

private val QuickSand = FontFamily(
    Font(R.font.quicksand_light, FontWeight.W300),
    Font(R.font.quicksand_regular, FontWeight.W400),
    Font(R.font.quicksand_medium, FontWeight.W500),
    Font(R.font.quicksand_semibold, FontWeight.W600),
    Font(R.font.quicksand_bold, FontWeight.W700)
)

val QuickSandTypography = Typography(
    h1 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W600,
        fontSize = 40.sp
    ),
    h2 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W500,
        fontSize = 30.sp
    ),
    h3 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),
    h4 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 20.sp
    ),
    h5 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    ),
    h6 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = QuickSand,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 15.sp,
        color = Color.White
    ),
    caption = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)