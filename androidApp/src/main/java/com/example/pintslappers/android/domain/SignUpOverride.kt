package com.example.pintslappers.android.domain

data class SignUpOverride(
    var overrideUsernameCheck: Boolean = false,
    var overridePasswordCheck: Boolean = false,
    var overrideConfirmPasswordCheck: Boolean = false,
) {
    fun overrideAll() {
        overrideUsernameCheck = true
        overridePasswordCheck = true
        overrideConfirmPasswordCheck = true
    }
}