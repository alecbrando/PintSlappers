package com.example.pintslappers.android.composeFormValidation.annotations

import com.example.pintslappers.android.composeFormValidation.abstractions.ValidationRule
import kotlin.reflect.KClass

@Target(AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class FieldValidation(
    val fieldType: KClass<out Any>,
    val validator: KClass<out ValidationRule>
)