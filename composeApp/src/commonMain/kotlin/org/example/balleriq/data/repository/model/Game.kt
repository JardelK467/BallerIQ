package org.example.balleriq.data.repository.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Game(
    @SerialName("id")
    var id: Int,
    @SerialName("date")
    var date: String,
    @SerialName("league")
    var leagueId: Int,
    @SerialName("team")
    var teamId: Int,
    @SerialName("timezone")
    var timezone: String
)
