package com.example.pintslappers.android.composeFormValidation.composeui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.example.pintslappers.android.composeFormValidation.FieldResult
import com.example.pintslappers.android.composeFormValidation.FieldValue
import com.example.pintslappers.android.composeFormValidation.abstractions.FormField
import com.example.pintslappers.android.composeFormValidation.abstractions.FormFieldScope


internal class FormFieldScopeImpl<V : Any>(
    private val formField: FormField<V>
) : FormFieldScope<V> {

    override val state: State<FieldValue<V>?>
        @Composable
        get() = formField.valueStream.collectAsState(null)

    override val resultState: State<FieldResult>
        @Composable
        get() = formField.resultStream.collectAsState(FieldResult.NoInput)

    override fun setField(input: V?) {
        formField.setField(input)
    }
}
