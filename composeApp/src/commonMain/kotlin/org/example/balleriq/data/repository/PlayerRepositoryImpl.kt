package org.example.balleriq.data.repository

import io.ktor.client.call.*
import kotlinx.serialization.json.Json
import org.example.balleriq.domain.usecase.repository.PlayerRepository
import org.example.balleriq.core.network.BasketballAPI
import org.example.balleriq.data.repository.model.Player
import org.example.balleriq.core.network.ApiException

class PlayerRepositoryImpl(private val basketballAPI: BasketballAPI) : PlayerRepository {

    override suspend fun getPlayers(teamId: Int): List<Player> {
        val response = basketballAPI.getPlayers(teamId)
        return if (response.status.value in 200..299) {
            val responseBody: String = response.body()
            Json.decodeFromString<List<Player>>(responseBody)
        } else {
            throw ApiException("HTTP Error: ${response.status.value}", response.status.value)
        }
    }
}
