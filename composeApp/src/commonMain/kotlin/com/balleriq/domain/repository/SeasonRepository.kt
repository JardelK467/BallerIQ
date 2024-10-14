package com.balleriq.domain.repository

import com.balleriq.data.repository.model.Season

interface SeasonRepository {
    suspend fun getSeasons(): List<Season>
}
