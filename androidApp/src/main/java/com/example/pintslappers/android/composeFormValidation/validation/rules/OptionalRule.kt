package com.example.pintslappers.android.composeFormValidation.validation.rules

import com.example.pintslappers.android.composeFormValidation.FieldResult
import com.example.pintslappers.android.composeFormValidation.abstractions.StatelessValidation
import com.example.pintslappers.android.composeFormValidation.annotations.Optional

object OptionalRule : StatelessValidation<Any?, Optional> {
    // Nothing much here
    override fun validate(value: Any?, options: Optional): FieldResult {
        return FieldResult.Success
    }
}