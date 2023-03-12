package com.example.pintslappers.android.composeFormValidation.validation.validators

import com.example.pintslappers.android.composeFormValidation.FieldResult
import com.example.pintslappers.android.composeFormValidation.abstractions.FieldValidator
import com.example.pintslappers.android.composeFormValidation.abstractions.StatelessValidation

internal class StatelessFieldValidator<V : Any?, A : Annotation>(
    private val validationRule: StatelessValidation<V, A>,
    private val options: A
) : FieldValidator<V> {
    /**
     * Validates the field using just it's value, since the option is known
     *
     * @param input value of type [V]
     * @return
     */
    override fun validate(input: V): FieldResult {
        return validationRule.validate(input, options)
    }
}