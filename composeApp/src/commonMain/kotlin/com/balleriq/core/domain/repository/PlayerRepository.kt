package com.balleriq.core.domain.repository

import com.balleriq.core.data.model.Player

interface PlayerRepository {
    suspend fun getPlayers(teamId: Int): List<Player>
}
