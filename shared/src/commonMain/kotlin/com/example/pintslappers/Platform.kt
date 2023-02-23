package com.example.pintslappers

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform