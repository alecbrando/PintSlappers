package com.example.pintslappers.android.composeFormValidation.builder

import com.example.pintslappers.android.composeFormValidation.abstractions.CollectableFormData
import com.example.pintslappers.android.composeFormValidation.abstractions.FormField
import com.example.pintslappers.android.composeFormValidation.FormFieldImpl
import com.example.pintslappers.android.composeFormValidation.annotations.DynamicOptional
import com.example.pintslappers.android.composeFormValidation.utils.getEvaluatorInstance
import com.example.pintslappers.android.composeFormValidation.utils.isFieldOptional
import com.example.pintslappers.android.composeFormValidation.utils.validationAnnotations
import com.example.pintslappers.android.composeFormValidation.validation.optionalFlags.DefaultOptionalFlag
import com.example.pintslappers.android.composeFormValidation.abstractions.OptionalFlag
import com.example.pintslappers.android.composeFormValidation.validation.optionalFlags.RuleBasedOptionalFlag
import kotlin.reflect.KProperty1
import kotlin.reflect.full.findAnnotations
import kotlin.reflect.full.hasAnnotation

internal class FormFieldFactory<T: Any> (
    private val form: CollectableFormData<T>
) {

    /**
     * Factory instance for [FieldValidator] classes
     */
    private val fieldValidatorFactory: FormFieldValidatorFactory<T> by lazy {
        FormFieldValidatorFactory(form)
    }

    /**
     * A factory method that receives the property reference and constructs [FormField] object
     *
     * @param field kotlin property reference to the field
     * @return [FormField] instance ready to operate with
     */
    fun create(field: KProperty1<T, *>): FormField<Any> {

        // Create field validators
        val validators = field
            .validationAnnotations()
            .map(fieldValidatorFactory::create)
            .toSet()

        val optionalFlagEvaluators: Set<OptionalFlag> = if (field.hasAnnotation<DynamicOptional>()) {
            field.findAnnotations<DynamicOptional>()
                .map {
                    RuleBasedOptionalFlag(form, it.getEvaluatorInstance())
                }
                .toSet()

        } else {
            setOf(
                DefaultOptionalFlag(field.isFieldOptional())
            )
        }

        return FormFieldImpl(
            fieldClass = field as KProperty1<T, Any>,
            validators = validators,
            optionalStateEvaluators = optionalFlagEvaluators
        )
    }
}