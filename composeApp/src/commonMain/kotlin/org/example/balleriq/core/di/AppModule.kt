package org.example.balleriq.core.di

import org.example.balleriq.core.network.BasketballAPI
import org.example.balleriq.data.repository.*
import org.example.balleriq.domain.usecase.repository.GameRepository
import org.example.balleriq.domain.usecase.repository.LeagueRepository
import org.example.balleriq.domain.usecase.repository.PlayerRepository
import org.example.balleriq.domain.usecase.repository.TeamRepository
import org.koin.dsl.module

val appModule = module {
    single { BasketballAPI() }

    single<LeagueRepository> { LeagueRepositoryImpl(get()) }
    single<TeamRepository> { TeamRepositoryImpl(get()) }
    single<PlayerRepository> { PlayerRepositoryImpl(get()) }
    single<GameRepository> { GameRepositoryImpl(get()) }

}