package com.balleriq.core.data.repository

import com.balleriq.core.data.model.Season
import com.balleriq.core.domain.repository.SeasonRepository
import com.balleriq.core.network.ApiResponse
import com.balleriq.core.network.BasketballAPI
import com.balleriq.core.utils.handleResponse
import io.ktor.client.call.body
import kotlinx.serialization.json.Json

class SeasonRepositoryImpl(private val basketballAPI: BasketballAPI) : SeasonRepository {
    override suspend fun getSeasons(): List<Season> {
        return handleResponse(
            response = fetchSeasons(),
            onSuccess = { it },
            onError = { message, code ->
                throw Exception("Failed to fetch seasons: $message (Code: $code)")
            },
        )
    }

    private suspend fun fetchSeasons(): ApiResponse<List<Season>> {
        val response = basketballAPI.getSeasons()
        return if (response.status.value in 200..299) {
            val responseBody: String = response.body()
            val seasons = Json.decodeFromString<List<Season>>(responseBody)
            ApiResponse.Success(seasons)
        } else {
            ApiResponse.Error("HTTP Error: ${response.status.value}", response.status.value)
        }
    }
}
