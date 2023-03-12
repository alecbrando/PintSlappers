package com.example.pintslappers.android.composeFormValidation.validation.rules

interface OptionalStateRule<T> {
    fun isOptional(state: T): Boolean
}