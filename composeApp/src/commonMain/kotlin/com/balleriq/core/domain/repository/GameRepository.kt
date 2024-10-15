package com.balleriq.core.domain.repository

import com.balleriq.core.data.model.Game

interface GameRepository {
    suspend fun getGames(
        leagueId: Int,
        season: String,
    ): List<Game>
}
