package com.balleriq.domain.repository

import com.balleriq.data.repository.model.Player

interface PlayerRepository {
    suspend fun getPlayers(teamId: Int): List<Player>
}
