package org.example.balleriq.data.repository

import io.ktor.client.call.*
import kotlinx.serialization.json.Json
import org.example.balleriq.domain.usecase.repository.LeagueRepository
import org.example.balleriq.core.network.BasketballAPI
import org.example.balleriq.data.repository.model.League
import org.example.balleriq.core.network.ApiException

class LeagueRepositoryImpl(private val basketballAPI: BasketballAPI) : LeagueRepository {

    override suspend fun getLeagues(): List<League> {
        val response = basketballAPI.getLeagues()
        return if (response.status.value in 200..299) {
            val responseBody: String = response.body()
            Json.decodeFromString<List<League>>(responseBody)
        } else {
            throw ApiException("HTTP Error: ${response.status.value}", response.status.value)
        }
    }
}



