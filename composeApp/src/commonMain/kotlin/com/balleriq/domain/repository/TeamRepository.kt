package com.balleriq.domain.repository

import com.balleriq.data.repository.model.Team

interface TeamRepository {
    suspend fun getTeams(leagueId: Int): List<Team>
}
