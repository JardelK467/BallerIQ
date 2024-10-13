package org.example.balleriq.data.repository.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Timezone(
    @SerialName("timezone")
    val timezone: List<String>
)
