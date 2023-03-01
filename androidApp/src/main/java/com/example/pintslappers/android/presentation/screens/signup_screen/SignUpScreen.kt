package com.example.pintslappers.android.presentation.screens.signup_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pintslappers.android.PintSlappersTheme
import com.example.pintslappers.android.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpScreen(
    navController: NavController? = null
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween, // Add this to align items at opposite ends
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "Back"
                    )
                }
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Register", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    ) {
        // TopBar()
        Column(modifier = Modifier.fillMaxSize()) {

        }
    }
}


@Preview
@Composable
fun SignUpScreenPreview() {
    PintSlappersTheme {
        SignUpScreen()
    }
}