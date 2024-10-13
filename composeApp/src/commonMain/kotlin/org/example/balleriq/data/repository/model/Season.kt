package org.example.balleriq.data.repository.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Season(
    @SerialName("seasons")
    val seasons: List<String>
)
