package com.example.pintslappers.android.presentation.screens.signup_screen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pintslappers.android.PintSlappersTheme
import com.example.pintslappers.android.R
import com.example.pintslappers.android.composeFormValidation.FieldResult
import com.example.pintslappers.android.composeFormValidation.composeui.field
import com.example.pintslappers.android.composeFormValidation.composeui.form
import com.example.pintslappers.android.domain.SignUpForm


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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
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
        val focused = remember {
            mutableStateOf(false)
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            form(SignUpForm::class) {
                field(SignUpForm::password) {
                    OutlinedTextField(
                        value = state.value?.value.orEmpty(),
                        onValueChange = { setField(it.ifEmpty { null }) },
                        modifier = Modifier.onFocusChanged {
                            focused.value = it.isFocused
                        },
                    )
                    AnimatedVisibility(
                        resultState.value is FieldResult.Error && !focused.value
                    ) {
                        val result = resultState.value
                        if (result is FieldResult.Error) {
                            Text(
                                text = result.message,
                                color = MaterialTheme.colorScheme.error,
                                modifier = Modifier.padding(start = 20.dp)
                            )
                        }
                    }
                }
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    modifier = Modifier.onFocusChanged {
                        if (!it.isFocused) {
                        }
                    },
                )
                Button(onClick = {  }) {
                   Text(text = "Validate")
                }
            }
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