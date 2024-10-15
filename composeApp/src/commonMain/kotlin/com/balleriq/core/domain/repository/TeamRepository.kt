package com.balleriq.core.domain.repository

import com.balleriq.core.data.model.Team

interface TeamRepository {
    suspend fun getTeams(leagueId: Int): List<Team>
}
