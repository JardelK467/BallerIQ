package com.balleriq.core.data.repository

import com.balleriq.core.data.model.League
import com.balleriq.core.domain.repository.LeagueRepository
import com.balleriq.core.network.ApiResponse
import com.balleriq.core.network.BasketballAPI
import com.balleriq.core.utils.handleResponse
import io.ktor.client.call.*
import kotlinx.serialization.json.Json

class LeagueRepositoryImpl(private val basketballAPI: BasketballAPI) : LeagueRepository {
    override suspend fun getLeagues(): List<League> {
        return handleResponse(
            response = fetchLeagues(),
            onSuccess = { it },
            onError = { message, code ->
                throw Exception("Failed to fetch leagues: $message (Code: $code)")
            },
        )
    }

    private suspend fun fetchLeagues(): ApiResponse<List<League>> {
        val response = basketballAPI.getLeagues()
        return if (response.status.value in 200..299) {
            val responseBody: String = response.body()
            val leagues = Json.decodeFromString<List<League>>(responseBody)
            ApiResponse.Success(leagues)
        } else {
            ApiResponse.Error("HTTP Error: ${response.status.value}", response.status.value)
        }
    }
}
