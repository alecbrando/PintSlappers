package com.example.pintslappers.android.composeFormValidation
import com.example.pintslappers.android.composeFormValidation.abstractions.FormField
import com.example.pintslappers.android.composeFormValidation.abstractions.OptionalFlag
import com.example.pintslappers.android.composeFormValidation.validation.rules.OptionalRule
import com.example.pintslappers.android.composeFormValidation.abstractions.FieldValidator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.reflect.KProperty1

internal class FormFieldImpl<T : Any, V : Any>(
    private val fieldClass: KProperty1<T, V>,
    private val validators: Set<FieldValidator<V>> = emptySet(),
    private val optionalStateEvaluators: Set<OptionalFlag> = emptySet()
) : FormField<V> {

    override val fieldName: String = fieldClass.name

    override val valueStream: MutableStateFlow<FieldValue<V>> = MutableStateFlow(
        FieldValue(null)
    )

    override val resultStream: MutableStateFlow<FieldResult> = MutableStateFlow(FieldResult.NoInput)

    override val value: V?
        get() = valueStream.value.value

    /**
     * Sets the value of the field
     *
     * The function validates the field if the input is not **empty** or the field isn't **optional**
     *
     * @param input
     */
    override fun setField(input: V?) {
        valueStream.value = valueStream.value.copy(value = input)

        // Null and empty strings are skipped for validation
        if (input != null && input != "") {
            resultStream.value = validate(input)
        }
        else {
            resultStream.value = if (isFieldOptional()) {
                FieldResult.Success
            } else {
                FieldResult.Error("This field is required", OptionalRule)
            }
        }
    }

    /**
     * Validates the input value without updating the field itself
     *
     * @param input input value of type [V]
     * @return [FieldResult] object after validation
     */
    override fun validate(input: V): FieldResult {
        // Validate using each of the validators
        val validationResult = validators.map { it.validate(input) }

        // Check if all validation is Success
        val validationSuccess = validationResult.all { it is FieldResult.Success }

        // Check if error exists
        val error = validationResult.firstOrNull { it is FieldResult.Error }

        return if (validationSuccess) {
            FieldResult.Success
        } else {
            // returns No Input when there's no error and validation fails
            error ?: FieldResult.NoInput
        }
    }

    override fun isFieldOptional(): Boolean {
        return if (optionalStateEvaluators.isEmpty()) {
            // This means there's no optional flags applied
            false
        } else {
            optionalStateEvaluators.all(OptionalFlag::evaluate)
        }
    }
}