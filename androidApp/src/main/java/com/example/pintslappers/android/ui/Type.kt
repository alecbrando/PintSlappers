package com.example.pintslappers.android.ui

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pintslappers.android.R

val Typography by lazy {
    Typography(
        headlineLarge = TextStyle(
            fontFamily = RobotoFont,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            lineHeight = 28.sp,
            letterSpacing = .25.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = RobotoFont,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = .15.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = RobotoFont,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = RobotoFont,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = .15.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = RobotoFont,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = .25.sp
        ),
        bodySmall = TextStyle(
            fontFamily = RobotoFont,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = .4.sp
        ),
        labelLarge = TextStyle(
            fontFamily = RobotoFont,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 24.sp,
            letterSpacing = .15.sp
        ),
        labelMedium = TextStyle(
            fontFamily = RobotoFont,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = .1.sp
        ),
    )
}

val RobotoFont = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_thin, FontWeight.Thin),
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_black, FontWeight.Black),
)

