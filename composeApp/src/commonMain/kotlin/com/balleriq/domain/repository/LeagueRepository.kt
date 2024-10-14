package com.balleriq.domain.repository

import com.balleriq.data.repository.model.League

interface LeagueRepository {
    suspend fun getLeagues(): List<League>
}
