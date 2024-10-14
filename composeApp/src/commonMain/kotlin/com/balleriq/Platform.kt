package com.balleriq

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
