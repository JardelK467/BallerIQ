package com.balleriq.core.data.repository

import com.balleriq.core.data.model.Game
import com.balleriq.core.domain.repository.GameRepository
import com.balleriq.core.network.ApiResponse
import com.balleriq.core.network.BasketballAPI
import com.balleriq.core.utils.handleResponse
import io.ktor.client.call.*
import kotlinx.serialization.json.Json

class GameRepositoryImpl(private val basketballAPI: BasketballAPI) : GameRepository {
    override suspend fun getGames(
        leagueId: Int,
        season: String,
    ): List<Game> {
        return handleResponse(
            response = fetchGames(leagueId, season),
            onSuccess = { it },
            onError = { message, code ->
                throw Exception("Failed to fetch games: $message (Code: $code)")
            },
        )
    }

    private suspend fun fetchGames(
        leagueId: Int,
        season: String,
    ): ApiResponse<List<Game>> {
        val response = basketballAPI.getGames(leagueId, season)
        return if (response.status.value in 200..299) {
            val responseBody: String = response.body()
            val games = Json.decodeFromString<List<Game>>(responseBody)
            ApiResponse.Success(games)
        } else {
            ApiResponse.Error("HTTP Error: ${response.status.value}", response.status.value)
        }
    }
}
