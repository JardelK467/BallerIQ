package org.example.balleriq.domain.usecase.repository

import org.example.balleriq.data.repository.model.Game

interface GameRepository {
    suspend fun getGames(leagueId: Int, season: String): List<Game>
}