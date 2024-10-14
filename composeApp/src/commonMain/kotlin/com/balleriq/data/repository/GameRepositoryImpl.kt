package com.balleriq.data.repository

import com.balleriq.core.network.ApiException
import com.balleriq.core.network.BasketballAPI
import com.balleriq.data.repository.model.Game
import com.balleriq.domain.repository.GameRepository
import io.ktor.client.call.*
import kotlinx.serialization.json.Json

class GameRepositoryImpl(private val basketballAPI: BasketballAPI) : GameRepository {
    override suspend fun getGames(
        leagueId: Int,
        season: String,
    ): List<Game> {
        val response = basketballAPI.getGames(leagueId, season)
        return if (response.status.value in 200..299) {
            val responseBody: String = response.body()
            Json.decodeFromString<List<Game>>(responseBody)
        } else {
            throw ApiException("HTTP Error: ${response.status.value}", response.status.value)
        }
    }
}
