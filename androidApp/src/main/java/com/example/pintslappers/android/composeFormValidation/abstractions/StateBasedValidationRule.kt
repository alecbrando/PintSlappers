package com.example.pintslappers.android.composeFormValidation.abstractions

import com.example.pintslappers.android.composeFormValidation.FieldResult

interface StateBasedValidationRule<V : Any?, A : Annotation, T : Any> : ValidationRule {
    fun validate(value: V, options: A, formState: T): FieldResult
}