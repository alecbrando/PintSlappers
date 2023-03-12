package com.example.pintslappers.android.validationRules.Validators

import com.example.pintslappers.android.composeFormValidation.annotations.FieldValidation
import com.example.pintslappers.android.validationRules.Rules.ConfirmPasswordValidatorRule

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@FieldValidation(
    fieldType = String::class,
    validator = ConfirmPasswordValidatorRule::class
)
annotation class ConfirmPasswordValidator()