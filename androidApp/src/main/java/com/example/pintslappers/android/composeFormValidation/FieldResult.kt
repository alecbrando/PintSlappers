package com.example.pintslappers.android.composeFormValidation

import com.example.pintslappers.android.composeFormValidation.abstractions.ValidationRule

sealed class FieldResult {

    /**
     * Successful Validation
     */
    object Success : FieldResult()

    /**
     * Error type of FieldResult
     *
     * @property message error message from the library
     * @property failedRule the object instance of the rule with failed validation
     */
    data class Error(
        val message: String,
        val failedRule: ValidationRule
    ) : FieldResult()

    /**
     * Special case when the field has no interaction with user yet,
     * and thus, NoInput
     *
     * This is particularly useful when initializing a field value
     */
    object NoInput : FieldResult()
}
