package com.example.pintslappers.android.composeFormValidation.abstractions

import com.example.pintslappers.android.composeFormValidation.FieldResult


interface StatelessValidation<T: Any?, A : Annotation> : ValidationRule {
    fun validate(value: T, options: A): FieldResult
}