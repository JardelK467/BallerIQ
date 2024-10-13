package org.example.balleriq.domain.usecase.repository

import org.example.balleriq.data.repository.model.Player

interface PlayerRepository {
    suspend fun getPlayers(teamId: Int): List<Player>
}