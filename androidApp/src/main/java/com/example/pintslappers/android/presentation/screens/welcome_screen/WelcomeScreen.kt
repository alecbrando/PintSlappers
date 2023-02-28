package com.example.pintslappers.android.presentation.screens.welcome_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.navigation.NavController
import com.example.pintslappers.android.R

@Composable
fun WelcomeScreen(
    navController: NavController? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(){
            Image(painter = painterResource(id = R.drawable.beer_logo), contentDescription = "logo")
        }

        Surface() {
            Column() {
                // Welcome
                Text(text = "Welcome")
                // Lorem Ipsum
                Text(text =  LoremIpsum(20).toString())
                // Row
                Row(modifier = Modifier.fillMaxWidth()){
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Sign In")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewWelcomeScreen() {
    WelcomeScreen()
}