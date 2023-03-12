package com.example.pintslappers.android.composeFormValidation

import com.example.pintslappers.android.composeFormValidation.abstractions.StatelessValidation
import com.example.pintslappers.android.validationRules.Validators.PasswordValidator


object PasswordValidatorRule : StatelessValidation<String, PasswordValidator> {
    override fun validate(value: String, options: PasswordValidator): FieldResult {
        return when {
            !RegexForPassword.lengthSpaceCase.toRegex().containsMatchIn(value) -> FieldResult.Error(
                "Password must be between 8 and 50 characters long and contain at least one uppercase letter, one lowercase letter, and one number",
                this
            )
            else -> FieldResult.Success
        }
    }
}

object RegexForPassword {
    const val lengthSpaceCase = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\S]{8,50}$"
}
