package org.example.balleriq.model

data class League(
    val name: String,
    val country: String,
    val type: String,
    val season: Season,
    val code: String
)
