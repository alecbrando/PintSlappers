package com.example.pintslappers.android.composeFormValidation.abstractions

interface CollectableFormData<T : Any> {
    fun collectFormData(): T
}