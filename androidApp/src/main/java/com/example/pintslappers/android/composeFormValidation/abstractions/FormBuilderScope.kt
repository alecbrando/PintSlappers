package com.example.pintslappers.android.composeFormValidation.abstractions

import com.example.pintslappers.android.composeFormValidation.FormResult
import kotlinx.coroutines.flow.Flow
import kotlin.reflect.KProperty1

interface FormBuilderScope<T : Any> {

    val formState: Flow<FormResult<T>>

    fun <V : Any> registerField(fieldClass: KProperty1<T, V>): FormField<V>
}