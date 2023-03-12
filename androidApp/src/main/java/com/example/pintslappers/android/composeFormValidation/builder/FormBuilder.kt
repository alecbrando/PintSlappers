package com.example.pintslappers.android.composeFormValidation.builder

import com.example.pintslappers.android.composeFormValidation.abstractions.Form
import com.example.pintslappers.android.composeFormValidation.abstractions.FormField
import com.example.pintslappers.android.composeFormValidation.FormImpl
import com.example.pintslappers.android.composeFormValidation.abstractions.FormBuilderScope
import com.example.pintslappers.android.composeFormValidation.builder.impl.FormFieldBuilderScopeImpl
import kotlin.reflect.KProperty1
import kotlin.reflect.KClass

fun <T : Any> form(
    className: KClass<T>,
    builder: FormBuilderScope<T>.() -> Unit = {}
): Form<T> {
    val form = FormImpl(className)
    val scope = FormBuilderScopeImpl(form)
    scope.builder()
    return form
}

fun <T : Any, V : Any> FormBuilderScope<T>.field(
    fieldClass: KProperty1<T, V>,
    builder: FormFieldBuilderScope<V>.() -> Unit = {}
): FormField<V> {
    val field = registerField(fieldClass)
    val scope = FormFieldBuilderScopeImpl(field)
    scope.builder()
    return field
}

fun <T : Any, V : Any> Form<T>.field(
    fieldClass: KProperty1<T, V>,
    builder: FormFieldBuilderScope<V>.() -> Unit = {}
): FormField<V> {
    val field = registerField(fieldClass)
    val scope = FormFieldBuilderScopeImpl(field)
    scope.builder()
    return field
}