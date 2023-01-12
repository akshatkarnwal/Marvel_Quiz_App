package com.example.quizapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.quizapp.R

// Set of Material typography styles to start with
val Siliguri = FontFamily(
    Font(R.font.siliguri_bold, FontWeight.Bold),
    Font(R.font.siliguri_regular)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Siliguri,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    body1 = TextStyle(
        fontFamily = Siliguri,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    // Other default text styles to override
    button = TextStyle(
        fontFamily = Siliguri,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    /*
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)