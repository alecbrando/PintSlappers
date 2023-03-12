package com.example.pintslappers.android.domain

import com.example.pintslappers.android.composeFormValidation.annotations.IsForm
import com.example.pintslappers.android.composeFormValidation.validationRules.PasswordValidator

@IsForm
data class SignUpForm(
    @PasswordValidator()
    val password: String = ""
)