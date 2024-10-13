package org.example.balleriq.data.repository

import io.ktor.client.call.*
import kotlinx.serialization.json.Json
import org.example.balleriq.domain.usecase.repository.TeamRepository
import org.example.balleriq.core.network.BasketballAPI
import org.example.balleriq.data.repository.model.Team
import org.example.balleriq.core.network.ApiException

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
