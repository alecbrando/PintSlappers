package com.example.pintslappers.android.composeFormValidation.builder

import com.example.pintslappers.android.composeFormValidation.FieldResult
import com.example.pintslappers.android.composeFormValidation.FieldValue
import kotlinx.coroutines.flow.StateFlow

interface FormFieldBuilderScope<V : Any> {
    val state: StateFlow<FieldValue<V>>

    val resultState: StateFlow<FieldResult>

    fun setField(input: V?)
}