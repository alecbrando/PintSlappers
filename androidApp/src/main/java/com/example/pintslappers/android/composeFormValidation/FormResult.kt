package com.example.pintslappers.android.composeFormValidation

import com.example.pintslappers.android.composeFormValidation.abstractions.ValidationRule

sealed class FormResult<out T : Any> {

    /**
     * Successful state
     *
     * @param T type of form data
     * @property data an instance of [T] filled with form data
     */
    data class Success<T : Any> (
        val data: T
    ) : FormResult<T>()

    /**
     * Error State when validation fails
     *
     * @property failedRules contains a set of failed validation rules with error messages
     */
    data class Error(
        val failedRules: Set<ValidationRule>
    ) : FormResult<Nothing>()

    /**
     * A special case where the form has no interactions yet
     */
    object NoInput : FormResult<Nothing>()
}