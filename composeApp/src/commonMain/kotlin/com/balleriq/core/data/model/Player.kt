package com.balleriq.core.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Player(
    @SerialName("id")
    val id: Int,
    @SerialName("firstname")
    val firstName: String,
    @SerialName("lastname")
    val familyName: String,
    @SerialName("birth")
    val dob: String,
    @SerialName("height")
    val height: String,
    @SerialName("nationality")
    val nationality: String,
    @SerialName("jersey_number")
    val shirtNumber: String?,
)
