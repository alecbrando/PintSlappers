package com.example.pintslappers.android.composeFormValidation.builder

import com.example.pintslappers.android.composeFormValidation.abstractions.FormField
import com.example.pintslappers.android.composeFormValidation.FormImpl
import com.example.pintslappers.android.composeFormValidation.FormResult
import com.example.pintslappers.android.composeFormValidation.abstractions.FormBuilderScope
import kotlinx.coroutines.flow.Flow
import kotlin.reflect.KProperty1

class FormBuilderScopeImpl<T : Any>(
    private val form: FormImpl<T>
) : FormBuilderScope<T> {

    override val formState: Flow<FormResult<T>>
        get() = form.formDataStream

    override fun <V : Any> registerField(fieldClass: KProperty1<T, V>): FormField<V> {
        return form.registerField(fieldClass)
    }
}