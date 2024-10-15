package com.balleriq.core.domain.usecase

import com.balleriq.core.data.model.League
import com.balleriq.core.data.repository.LeagueRepositoryImpl

class GetLeaguesUseCase(private val leagueRepository: LeagueRepositoryImpl) {
    suspend fun execute(): List<League> {
        return leagueRepository.getLeagues()
    }
}
