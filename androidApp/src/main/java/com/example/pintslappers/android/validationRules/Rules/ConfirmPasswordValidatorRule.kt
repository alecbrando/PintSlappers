package com.example.pintslappers.android.validationRules.Rules

import com.example.pintslappers.android.composeFormValidation.FieldResult
import com.example.pintslappers.android.composeFormValidation.abstractions.StateBasedValidationRule
import com.example.pintslappers.android.domain.SignUpForm
import com.example.pintslappers.android.validationRules.Validators.ConfirmPasswordValidator

object ConfirmPasswordValidatorRule: StateBasedValidationRule<String, ConfirmPasswordValidator, SignUpForm> {
    override fun validate(value: String, options: ConfirmPasswordValidator, formState: SignUpForm): FieldResult {
       return when {
              value != formState.password -> FieldResult.Error("Passwords do not match", this)
              else -> FieldResult.Success
       }
    }
}