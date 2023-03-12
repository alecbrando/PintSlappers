package com.example.pintslappers.android.composeFormValidation.validation.optionalFlags

import com.example.pintslappers.android.composeFormValidation.abstractions.OptionalFlag

class DefaultOptionalFlag(
    private val isOptional: Boolean
): OptionalFlag {
    override fun evaluate(): Boolean = isOptional
}