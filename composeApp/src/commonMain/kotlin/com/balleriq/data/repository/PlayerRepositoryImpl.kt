package com.balleriq.data.repository

import com.balleriq.core.network.ApiException
import com.balleriq.core.network.BasketballAPI
import com.balleriq.data.repository.model.Player
import com.balleriq.domain.repository.PlayerRepository
import io.ktor.client.call.*
import kotlinx.serialization.json.Json

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
