package com.example.pintslappers.android.composeFormValidation.validation.optionalFlags

import com.example.pintslappers.android.composeFormValidation.abstractions.CollectableFormData
import com.example.pintslappers.android.composeFormValidation.abstractions.OptionalFlag
import com.example.pintslappers.android.composeFormValidation.validation.rules.OptionalStateRule


internal class RuleBasedOptionalFlag<T: Any>(
    private val formState: CollectableFormData<T>,
    private val rule: OptionalStateRule<T>
) : OptionalFlag {
    override fun evaluate(): Boolean {
        return rule.isOptional(formState.collectFormData())
    }
}