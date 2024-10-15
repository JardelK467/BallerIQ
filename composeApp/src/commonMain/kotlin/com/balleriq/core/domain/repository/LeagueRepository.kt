package com.balleriq.core.domain.repository

import com.balleriq.core.data.model.League

interface LeagueRepository {
    suspend fun getLeagues(): List<League>
}
