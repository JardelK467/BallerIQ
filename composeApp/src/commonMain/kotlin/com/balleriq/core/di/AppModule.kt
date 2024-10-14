package com.balleriq.core.di

import com.balleriq.core.network.BasketballAPI
import com.balleriq.data.repository.GameRepositoryImpl
import com.balleriq.data.repository.LeagueRepositoryImpl
import com.balleriq.data.repository.PlayerRepositoryImpl
import com.balleriq.data.repository.TeamRepositoryImpl
import com.balleriq.domain.repository.GameRepository
import com.balleriq.domain.repository.LeagueRepository
import com.balleriq.domain.repository.PlayerRepository
import com.balleriq.domain.repository.TeamRepository
import org.koin.dsl.module

val appModule =
    module {
        single { BasketballAPI() }

        single<LeagueRepository> { LeagueRepositoryImpl(get()) }
        single<TeamRepository> { TeamRepositoryImpl(get()) }
        single<PlayerRepository> { PlayerRepositoryImpl(get()) }
        single<GameRepository> { GameRepositoryImpl(get()) }
    }
