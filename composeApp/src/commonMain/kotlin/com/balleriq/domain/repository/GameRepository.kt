package com.balleriq.domain.repository

import com.balleriq.data.repository.model.Game

interface GameRepository {
    suspend fun getGames(
        leagueId: Int,
        season: String,
    ): List<Game>
}
