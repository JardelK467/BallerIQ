package com.balleriq.core.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class BasketballAPI {
    private val client =
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    },
                )
            }
        }

    private val baseUrl = "https://v1.basketball.api-sports.io/"
    private val apiKey = "336c67ff59424fc30de45fa3029f72eb"

    suspend fun getLeagues(): HttpResponse {
        return client.get("$baseUrl/leagues") {
            headers {
                append("x-rapidapi-key", apiKey)
            }
            parameter("country", "United Kingdom")
        }
    }

    suspend fun getTeams(leagueId: Int): HttpResponse {
        return client.get("$baseUrl/teams") {
            headers {
                append("x-rapidapi-key", apiKey)
            }
            parameter("league", leagueId)
        }
    }

    suspend fun getPlayers(teamId: Int): HttpResponse {
        return client.get("$baseUrl/players") {
            headers {
                append("x-rapidapi-key", apiKey)
            }
            parameter("team", teamId)
        }
    }

    suspend fun getGames(
        leagueId: Int,
        season: String,
    ): HttpResponse {
        return client.get("$baseUrl/games") {
            headers {
                append("x-rapidapi-key", apiKey)
            }
            parameter("league", leagueId)
            parameter("season", season)
        }
    }

    suspend fun getSeasons(): HttpResponse {
        return client.get("$baseUrl/seasons") {
            headers {
                append("x-rapidapi-key", apiKey)
            }
        }
    }
}
