package com.example.pintslappers.android.presentation.screens.signup_screen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pintslappers.android.PintSlappersTheme
import com.example.pintslappers.android.R
import com.example.pintslappers.android.composeFormValidation.FieldResult
import com.example.pintslappers.android.composeFormValidation.FieldValue
import com.example.pintslappers.android.composeFormValidation.FormResult
import com.example.pintslappers.android.composeFormValidation.composeui.field
import com.example.pintslappers.android.composeFormValidation.composeui.form
import com.example.pintslappers.android.domain.SignUpForm
import com.example.pintslappers.android.domain.SignUpOverride
import com.example.pintslappers.android.presentation.screens.signup_screen.components.ConfirmPasswordField
import com.example.pintslappers.android.presentation.screens.signup_screen.components.PasswordField
import com.example.pintslappers.android.presentation.screens.signup_screen.components.UsernameField

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
                    Text(text = "Login", style = MaterialTheme.typography.labelMedium)
                }
            }
        }
    ) {
        val formPayload = remember {
            mutableStateOf(SignUpForm())
        }
        val overrideCheck = remember {
            mutableStateOf(SignUpOverride())
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            form(SignUpForm::class) {
                field(SignUpForm::username) {
                    UsernameField(
                        state,
                        resultState,
                        overrideCheck.value.overrideUsernameCheck,
                    ) { username ->
                        setField(username)
                        formPayload.value = formPayload.value.copy(username = username ?: "")
                    }
                }
                field(SignUpForm::password) {
                    PasswordField(
                        state,
                        resultState,
                        overrideCheck.value.overridePasswordCheck,
                    ) { password ->
                        setField(password)
                        formPayload.value = formPayload.value.copy(password = password ?: "")
                    }
                }
                field(SignUpForm::confirmPassword) {
                    ConfirmPasswordField(
                        state,
                        resultState,
                        overrideCheck.value.overrideConfirmPasswordCheck,
                        {
                            overrideCheck.value.overrideAll()
                            val result = this@form.submit(formPayload.value)
                            if (result is FormResult.Success) {
                                result.data
                            }
                        },
                    ) { password ->
                        setField(password)
                        formPayload.value = formPayload.value.copy(confirmPassword = password ?: "")
                    }
                }
                Button(
                    onClick = {
                        overrideCheck.value.overrideAll()
                        val result = this.submit(formPayload.value)
                        if (result is FormResult.Success) {
                            result.data
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Text(text = "Register")
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