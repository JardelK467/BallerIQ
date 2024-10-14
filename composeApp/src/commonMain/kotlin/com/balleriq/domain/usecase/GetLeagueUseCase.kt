package com.balleriq.domain.usecase

import com.balleriq.data.repository.LeagueRepositoryImpl
import com.balleriq.data.repository.model.League

class GetLeaguesUseCase(private val leagueRepository: LeagueRepositoryImpl) {
    suspend fun execute(): List<League> {
        return leagueRepository.getLeagues()
    }
}
