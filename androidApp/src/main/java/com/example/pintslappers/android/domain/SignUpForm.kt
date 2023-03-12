package com.example.pintslappers.android.domain

import com.example.pintslappers.android.composeFormValidation.annotations.IsForm
import com.example.pintslappers.android.validationRules.Validators.ConfirmPasswordValidator
import com.example.pintslappers.android.validationRules.Validators.PasswordValidator
import com.example.pintslappers.android.validationRules.Validators.UsernameValidator

@IsForm
data class SignUpForm(
    @UsernameValidator()
    val username: String = "",
    @PasswordValidator()
    val password: String = "",
    @ConfirmPasswordValidator()
    val confirmPassword: String = ""
)