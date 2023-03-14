package com.example.bedebestoon.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bedebestoon.R


val openSansFamily = FontFamily(
    Font(R.font.opensans_regular, weight = FontWeight.Normal),
    Font(R.font.opensans_bold, weight = FontWeight.Bold),
    Font(R.font.opensans_bold_italic, weight = FontWeight.Bold , style = FontStyle.Italic),
    Font(R.font.opensans_extra_bold, weight = FontWeight.ExtraBold),
    Font(R.font.opensans_extra_bold_italic, weight = FontWeight.ExtraBold , style = FontStyle.Italic),
    Font(R.font.opensans_semi_bold_italic, weight = FontWeight.SemiBold , style = FontStyle.Italic),
    Font(R.font.opensans_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.opensans_light_italic, weight = FontWeight.Light , style = FontStyle.Italic),
    Font(R.font.opensans_light, weight = FontWeight.Light),
    Font(R.font.opensans_italic, weight = FontWeight.Normal , style = FontStyle.Italic)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = openSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    h1 = TextStyle(
        fontSize = 24.sp,
        fontFamily = openSansFamily,
        fontWeight = FontWeight.Bold
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