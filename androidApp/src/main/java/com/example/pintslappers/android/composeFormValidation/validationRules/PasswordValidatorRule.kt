package com.example.pintslappers.android.composeFormValidation

import com.example.pintslappers.android.composeFormValidation.abstractions.StatelessValidation
import com.example.pintslappers.android.composeFormValidation.validationRules.PasswordValidator


object PasswordValidatorRule : StatelessValidation<String, PasswordValidator> {
    override fun validate(value: String, options: PasswordValidator): FieldResult {
        return when {
            !value.matches(RegexForPassword.lengthSpaceCase.toRegex()) -> FieldResult.Error(
                "Password must be between 8 and 50 characters long and contain at least one uppercase letter, one lowercase letter, and one number",
                this
            )
            !value.matches(RegexForPassword.oneLetter.toRegex()) -> FieldResult.Error(
                "Password must contain at least one letter",
                this
            )
            !value.matches(RegexForPassword.oneNumber.toRegex()) -> FieldResult.Error(
                "Password must contain at least one number",
                this
            )
            else -> FieldResult.Success
        }
    }
}

object RegexForPassword {
    const val lengthSpaceCase = "^(?=.*[a-z])(?=.*A-Z)(?=.*[A-Z])[^\\s]{8,50}\$"
    const val oneLetter = ".*[a-zA-Z].*"
    const val oneNumber = ".*[0-9].*"
}
