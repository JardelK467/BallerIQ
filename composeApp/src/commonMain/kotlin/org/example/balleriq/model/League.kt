package org.example.balleriq.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class League(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("country")
    val country: String,
    @SerialName("type")
    val type: String,
    @SerialName("season")
    val season: Season,
    @SerialName("code")
    val code: String
)
