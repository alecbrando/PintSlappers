package com.example.pintslappers.android.presentation.screens.splash_screen.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.pintslappers.android.R


@Composable
fun BeerAnimation(
    navigateToLoginOrHome: () -> Unit
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.beer))
    val progress by animateLottieCompositionAsState(composition)
    if(progress == 1f) {
        Log.d("BeerAnimation", "Animation is done")
        navigateToLoginOrHome()
    }
    LottieAnimation(
        composition = composition,
        progress = progress,
    )
}