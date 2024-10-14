package com.balleriq.data.repository

import com.balleriq.core.network.ApiException
import com.balleriq.core.network.BasketballAPI
import com.balleriq.data.repository.model.League
import com.balleriq.domain.repository.LeagueRepository
import io.ktor.client.call.*
import kotlinx.serialization.json.Json

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
