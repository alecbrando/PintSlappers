package com.example.pintslappers.android.composeFormValidation.abstractions

import com.example.pintslappers.android.composeFormValidation.syntax.SyntaxResult
import kotlin.reflect.KProperty1

internal interface SyntaxProcessor {
    fun <T : Any, V : Any?> process(field: KProperty1<T, V>): SyntaxResult
}