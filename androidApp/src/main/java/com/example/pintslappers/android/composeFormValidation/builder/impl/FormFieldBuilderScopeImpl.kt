package com.example.pintslappers.android.composeFormValidation.builder.impl

import com.example.pintslappers.android.composeFormValidation.FieldResult
import com.example.pintslappers.android.composeFormValidation.FieldValue
import com.example.pintslappers.android.composeFormValidation.abstractions.FormField
import com.example.pintslappers.android.composeFormValidation.builder.FormFieldBuilderScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FormFieldBuilderScopeImpl<V : Any>(
    private val formField: FormField<V>
) : FormFieldBuilderScope<V> {

    override val state: StateFlow<FieldValue<V>>
        get() = formField.valueStream.asStateFlow()

    override val resultState: StateFlow<FieldResult>
        get() = formField.resultStream.asStateFlow()

    override fun setField(input: V?) {
        formField.setField(input)
    }
}