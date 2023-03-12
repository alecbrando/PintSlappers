package com.example.pintslappers.android.composeFormValidation.validation.validators

import com.example.pintslappers.android.composeFormValidation.abstractions.CollectableFormData
import com.example.pintslappers.android.composeFormValidation.FieldResult
import com.example.pintslappers.android.composeFormValidation.abstractions.FieldValidator
import com.example.pintslappers.android.composeFormValidation.abstractions.StateBasedValidationRule

internal class StateBasedFieldValidator<T: Any, V: Any?, A: Annotation>(
    private val form: CollectableFormData<T>,
    private val validationRule: StateBasedValidationRule<V, A, T>,
    private val options: A
) : FieldValidator<V> {
    override fun validate(input: V): FieldResult {
        return validationRule.validate(input, options, form.collectFormData())
    }
}