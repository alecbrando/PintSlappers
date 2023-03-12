package com.example.pintslappers.android.composeFormValidation.builder

import com.example.pintslappers.android.composeFormValidation.abstractions.CollectableFormData
import com.example.pintslappers.android.composeFormValidation.annotations.FieldValidation
import com.example.pintslappers.android.composeFormValidation.utils.getFieldValidationData
import com.example.pintslappers.android.composeFormValidation.abstractions.StateBasedValidationRule
import com.example.pintslappers.android.composeFormValidation.abstractions.FieldValidator
import com.example.pintslappers.android.composeFormValidation.validation.validators.StateBasedFieldValidator
import com.example.pintslappers.android.composeFormValidation.validation.validators.StatelessFieldValidator
import com.example.pintslappers.android.composeFormValidation.abstractions.StatelessValidation

internal class FormFieldValidatorFactory<T: Any>(
    private val form: CollectableFormData<T>
) {
    fun create(
        validatorOptions: Annotation
    ): FieldValidator<Any> {
        val fieldValidationAnnotation: FieldValidation = validatorOptions.getFieldValidationData()
        return when (
            val validationRule = fieldValidationAnnotation.validator.objectInstance
        ) {
            is StatelessValidation<*, *> ->
                StatelessFieldValidator(
                    validationRule = validationRule as StatelessValidation<Any, Annotation>,
                    options = validatorOptions
                )
            is StateBasedValidationRule<*, *, *> ->
                StateBasedFieldValidator(
                    validationRule = validationRule as StateBasedValidationRule<Any, Annotation, T>,
                    options = validatorOptions,
                    form = form
                )
            else -> {
                throw IllegalArgumentException(
                    """
                        |Incompatible Validation Rule type ${fieldValidationAnnotation.validator.simpleName} is provided
                        |for annotation ${validatorOptions.annotationClass.simpleName}
                    """.trimMargin()
                )
            }
        }
    }
}