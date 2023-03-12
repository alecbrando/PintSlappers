package com.example.pintslappers.android.presentation.screens.signup_screen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.pintslappers.android.composeFormValidation.FieldResult
import com.example.pintslappers.android.composeFormValidation.FieldValue

@Composable
fun ConfirmPasswordField(
    state: State<FieldValue<String>?>,
    resultState: State<FieldResult>,
    overrideCheck: Boolean,
    onImeActionDone: () -> Unit,
    setField: (String?) -> Unit,
) {
    val focused = remember {
        mutableStateOf(false)
    }
    var visibility by remember {
        mutableStateOf(false)
    }
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = state.value?.value.orEmpty(),
        onValueChange = { setField(it.ifEmpty { null }) },
        textStyle = MaterialTheme.typography.labelMedium,
        placeholder = { Text(text = "Confirm Password") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()
            onImeActionDone()
        }),
        label = { Text(text = "Confirm Password") },
        isError = resultState.value is FieldResult.Error && (!focused.value || overrideCheck),
        visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { visibility = !visibility }) {
                Icon(
                    imageVector = if (visibility) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = "Visibility"
                )
            }
        },
        modifier = Modifier
            .onFocusChanged {
                focused.value = it.isFocused
            }
            .fillMaxWidth(),
    )
    AnimatedVisibility(
        resultState.value is FieldResult.Error && (!focused.value || overrideCheck)
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