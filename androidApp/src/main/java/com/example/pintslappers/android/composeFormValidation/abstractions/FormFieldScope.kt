package com.example.pintslappers.android.composeFormValidation.abstractions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.example.pintslappers.android.composeFormValidation.FieldResult
import com.example.pintslappers.android.composeFormValidation.FieldValue


interface FormFieldScope<V : Any> {

    /**
     * Observable State instance of [FieldValue]
     */
    val state: State<FieldValue<V>?>
        @Composable get

    /**
     * Observable State instance of [FieldResult]
     *
     * You can use this for validation results
     */
    val resultState: State<FieldResult>
        @Composable get

    /**
     * A setter function for field value
     *
     * You're encouraged to set the field value only using this function
     *
     * @param input input value
     */
    fun setField(input: V?)
}