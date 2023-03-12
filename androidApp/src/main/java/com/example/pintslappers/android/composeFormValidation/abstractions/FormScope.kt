package com.example.pintslappers.android.composeFormValidation.abstractions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.example.pintslappers.android.composeFormValidation.FormResult
import kotlin.reflect.KProperty1

interface FormScope<T : Any> {

    /**
     * Registers the field and returns a singleton FormField instance
     *
     * @param V type of field value
     * @param fieldClass kotlin property reference of the field
     * @return
     */
    fun <V : Any> registerField(fieldClass: KProperty1<T, V>): FormField<V>

    fun validate(): FormResult<T>

    fun submit(payload: T): FormResult<T>

    val formState: State<FormResult<T>>
        @Composable get
}