package com.example.pintslappers.android.presentation.screens.signup_screen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.pintslappers.android.composeFormValidation.FieldResult
import com.example.pintslappers.android.composeFormValidation.FieldValue

@Composable
fun UsernameField(
    state: State<FieldValue<String>?>,
    resultState: State<FieldResult>,
    overrideCheck: Boolean,
    setField: (String?) -> Unit,
) {
    val focused = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = state.value?.value.orEmpty(),
        onValueChange = { setField(it.ifEmpty { null }) },
        textStyle = MaterialTheme.typography.labelMedium,
        placeholder = { Text(text = "Enter a Username") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        label = { Text(text = "Username") },
        isError = resultState.value is FieldResult.Error && (!focused.value || overrideCheck),
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