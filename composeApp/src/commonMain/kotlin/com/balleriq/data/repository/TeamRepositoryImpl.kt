package com.balleriq.data.repository

import com.balleriq.core.network.ApiException
import com.balleriq.core.network.BasketballAPI
import com.balleriq.data.repository.model.Team
import com.balleriq.domain.repository.TeamRepository
import io.ktor.client.call.*
import kotlinx.serialization.json.Json

class TeamRepositoryImpl(private val basketballAPI: BasketballAPI) : TeamRepository {
    override suspend fun getTeams(leagueId: Int): List<Team> {
        val response = basketballAPI.getTeams(leagueId)
        return if (response.status.value in 200..299) {
            val responseBody: String = response.body()
            Json.decodeFromString<List<Team>>(responseBody)
        } else {
            throw ApiException("HTTP Error: ${response.status.value}", response.status.value)
        }
    }
}
