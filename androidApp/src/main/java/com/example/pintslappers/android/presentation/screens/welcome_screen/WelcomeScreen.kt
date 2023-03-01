package com.example.pintslappers.android.presentation.screens.welcome_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pintslappers.android.PintSlappersTheme
import com.example.pintslappers.android.R
import com.example.pintslappers.android.ui.DarkMustard
import com.example.pintslappers.android.ui.primaryButtonColor
import com.example.pintslappers.android.ui.secondaryButtonColor

@Composable
fun WelcomeScreen(
    navController: NavController? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(.5f)
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.beer_logo),
                contentDescription = "logo",
                modifier = Modifier.height(150.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Pint Slappers", style = MaterialTheme.typography.headlineLarge)
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(.5f)
                .fillMaxWidth()
                .weight(1f)
                .clip(
                    RoundedCornerShape(
                        topStart = 50.dp,
                        topEnd = 50.dp
                    )
                ),
            color = MaterialTheme.colorScheme.primary,
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(26.dp))
                // Welcome
                Text(text = "Welcome", style = MaterialTheme.typography.headlineLarge)
                Spacer(modifier = Modifier.height(16.dp))
                // Lorem Ipsum
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sodales laoreet commodo. Phasellus a purus eu risus elementum consequat",
                    style = MaterialTheme.typography.bodyLarge
                )
                // Row
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(.3f),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .height(60.dp)
                                .weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primaryButtonColor,
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "Sign In", style = MaterialTheme.typography.titleMedium)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .height(60.dp)
                                .weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondaryButtonColor,
                                contentColor = Color.Black
                            )
                        ) {
                            Text(text = "Sign Up", style = MaterialTheme.typography.titleMedium)
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewWelcomeScreen() {
    PintSlappersTheme {
        WelcomeScreen()
    }
}