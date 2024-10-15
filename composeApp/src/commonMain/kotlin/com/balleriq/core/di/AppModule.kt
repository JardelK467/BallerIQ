package com.balleriq.core.di

import com.balleriq.core.data.repository.GameRepositoryImpl
import com.balleriq.core.data.repository.LeagueRepositoryImpl
import com.balleriq.core.data.repository.PlayerRepositoryImpl
import com.balleriq.core.data.repository.TeamRepositoryImpl
import com.balleriq.core.domain.repository.GameRepository
import com.balleriq.core.domain.repository.LeagueRepository
import com.balleriq.core.domain.repository.PlayerRepository
import com.balleriq.core.domain.repository.TeamRepository
import com.balleriq.core.network.BasketballAPI
import org.koin.dsl.module

val appModule =
    module {
        single { BasketballAPI() }

        single<LeagueRepository> { LeagueRepositoryImpl(get()) }
        single<TeamRepository> { TeamRepositoryImpl(get()) }
        single<PlayerRepository> { PlayerRepositoryImpl(get()) }
        single<GameRepository> { GameRepositoryImpl(get()) }
    }
