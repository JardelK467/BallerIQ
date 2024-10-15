package com.balleriq.core.domain.repository

import com.balleriq.core.data.model.Season

interface SeasonRepository {
    suspend fun getSeasons(): List<Season>
}
