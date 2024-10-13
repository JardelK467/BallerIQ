package org.example.balleriq.domain.usecase.repository

import org.example.balleriq.data.repository.model.League

interface LeagueRepository {
    suspend fun getLeagues(): List<League>
}