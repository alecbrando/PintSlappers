package com.example.pintslappers.android.composeFormValidation.abstractions

import com.example.pintslappers.android.composeFormValidation.FieldResult

internal interface FieldValidator<V: Any?> {
    fun validate(input: V): FieldResult
}