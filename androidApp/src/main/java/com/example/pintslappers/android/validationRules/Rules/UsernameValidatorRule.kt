package com.example.pintslappers.android.validationRules

import com.example.pintslappers.android.composeFormValidation.FieldResult
import com.example.pintslappers.android.composeFormValidation.abstractions.StatelessValidation
import com.example.pintslappers.android.validationRules.Validators.UsernameValidator

object UsernameValidatorRule : StatelessValidation<String, UsernameValidator> {
    override fun validate(value: String, options: UsernameValidator): FieldResult {
        return when {
            !value.matches(RegexForUsername.minimumLength.toRegex()) -> FieldResult.Error(
                "Your username must at least 8 characters long",
                this
            )
            else -> FieldResult.Success
        }
    }
}

object RegexForUsername {
    const val minimumLength = "^[a-zA-Z0-9_]{8,}\$"
}