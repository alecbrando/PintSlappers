package com.example.pintslappers.android.composeFormValidation.composeui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.example.pintslappers.android.composeFormValidation.abstractions.FormField
import com.example.pintslappers.android.composeFormValidation.FormImpl
import com.example.pintslappers.android.composeFormValidation.FormResult
import com.example.pintslappers.android.composeFormValidation.abstractions.FormScope
import kotlin.reflect.KProperty1

internal class FormScopeImpl<T : Any>(
    private val form: FormImpl<T>
) : FormScope<T> {
    override fun <V : Any> registerField(
        fieldClass: KProperty1<T, V>
    ): FormField<V> {
        return form.registerField(fieldClass)
    }

    override val formState: State<FormResult<T>>
        @Composable
        get() = form.formDataStream.collectAsState(FormResult.NoInput)

    override fun validate(): FormResult<T> {
        return form.validate()
    }

    override fun submit(payload: T): FormResult<T> {
        return form.submit(payload)
    }
}