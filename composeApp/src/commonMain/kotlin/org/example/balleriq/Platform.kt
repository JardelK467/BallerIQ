package org.example.balleriq

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform