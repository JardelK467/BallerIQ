package org.example.balleriq.domain.usecase.repository

import org.example.balleriq.data.repository.model.Team

interface TeamRepository {
    suspend fun getTeams(leagueId: Int): List<Team>
}