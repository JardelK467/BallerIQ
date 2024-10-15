package com.balleriq.core.data.repository

import com.balleriq.core.data.model.Player
import com.balleriq.core.domain.repository.PlayerRepository
import com.balleriq.core.network.ApiResponse
import com.balleriq.core.network.BasketballAPI
import com.balleriq.core.utils.handleResponse
import io.ktor.client.call.*
import kotlinx.serialization.json.Json

class PlayerRepositoryImpl(private val basketballAPI: BasketballAPI) : PlayerRepository {
    override suspend fun getPlayers(teamId: Int): List<Player> {
        return handleResponse(
            response = fetchPlayers(teamId),
            onSuccess = { it },
            onError = { message, code ->
                throw Exception("Failed to fetch players: $message (Code: $code)")
            },
        )
    }

    private suspend fun fetchPlayers(teamId: Int): ApiResponse<List<Player>> {
        val response = basketballAPI.getPlayers(teamId)
        return if (response.status.value in 200..299) {
            val responseBody: String = response.body()
            val players = Json.decodeFromString<List<Player>>(responseBody)
            ApiResponse.Success(players)
        } else {
            ApiResponse.Error("HTTP Error: ${response.status.value}", response.status.value)
        }
    }
}
