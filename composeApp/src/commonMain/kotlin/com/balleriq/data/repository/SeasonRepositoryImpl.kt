package com.balleriq.data.repository

import com.balleriq.core.network.ApiException
import com.balleriq.core.network.BasketballAPI
import com.balleriq.data.repository.model.Season
import com.balleriq.domain.repository.SeasonRepository
import io.ktor.client.call.body
import kotlinx.serialization.json.Json

class SeasonRepositoryImpl(private val basketballAPI: BasketballAPI) : SeasonRepository {
    override suspend fun getSeasons(): List<Season> {
        val response = basketballAPI.getSeasons()
        return if (response.status.value in 200..299) {
            val responseBody: String = response.body()
            Json.decodeFromString<List<Season>>(responseBody)
        } else {
            throw ApiException("HTTP Error: ${response.status.value}", response.status.value)
        }
    }
}
