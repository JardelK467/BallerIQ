package com.balleriq.core.data.repository

import com.balleriq.core.data.model.Team
import com.balleriq.core.domain.repository.TeamRepository
import com.balleriq.core.network.ApiResponse
import com.balleriq.core.network.BasketballAPI
import com.balleriq.core.utils.handleResponse
import io.ktor.client.call.*
import kotlinx.serialization.json.Json

class TeamRepositoryImpl(private val basketballAPI: BasketballAPI) : TeamRepository {
    override suspend fun getTeams(leagueId: Int): List<Team> {
        return handleResponse(
            response = fetchTeams(leagueId),
            onSuccess = { it },
            onError = { message, code ->
                throw Exception("Failed to fetch teams: $message (Code: $code)")
            },
        )
    }

    private suspend fun fetchTeams(leagueId: Int): ApiResponse<List<Team>> {
        val response = basketballAPI.getTeams(leagueId)
        return if (response.status.value in 200..299) {
            val responseBody: String = response.body()
            val teams = Json.decodeFromString<List<Team>>(responseBody)
            ApiResponse.Success(teams)
        } else {
            ApiResponse.Error("HTTP Error: ${response.status.value}", response.status.value)
        }
    }
}
