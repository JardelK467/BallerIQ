package org.example.balleriq.data.repository

import io.ktor.client.call.*
import kotlinx.serialization.json.Json
import org.example.balleriq.domain.usecase.repository.GameRepository
import org.example.balleriq.core.network.BasketballAPI
import org.example.balleriq.data.repository.model.Game
import org.example.balleriq.core.network.ApiException

class GameRepositoryImpl(private val basketballAPI: BasketballAPI) : GameRepository {

    override suspend fun getGames(leagueId: Int, season: String): List<Game> {
        val response = basketballAPI.getGames(leagueId, season)
        return if (response.status.value in 200..299) {
            val responseBody: String = response.body()
            Json.decodeFromString<List<Game>>(responseBody)
        } else {
            throw ApiException("HTTP Error: ${response.status.value}", response.status.value)
        }
    }
}
