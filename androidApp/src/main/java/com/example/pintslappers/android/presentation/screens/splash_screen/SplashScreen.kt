package com.example.pintslappers.android.presentation.screens.splash_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.pintslappers.android.presentation.screens.splash_screen.components.BeerAnimation

@Composable
fun SplashScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)){
        BeerAnimation(){
            //Todo: Navigate to welcome or home
            navController.navigate("welcome"){
                popUpTo("splash"){
                    inclusive = true
                }
            }
        }
    }
}