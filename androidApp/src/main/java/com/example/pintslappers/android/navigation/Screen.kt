package com.example.pintslappers.android.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash")
    object Welcome: Screen("welcome")
    object Login: Screen("login")
    object SignUp: Screen("signup")
}
