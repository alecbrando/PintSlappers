package com.example.pintslappers.android.composeFormValidation.annotations

import com.example.pintslappers.android.composeFormValidation.validation.rules.OptionalStateRule
import kotlin.reflect.KClass

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class DynamicOptional(
    val evaluator: KClass<out OptionalStateRule<*>>
)