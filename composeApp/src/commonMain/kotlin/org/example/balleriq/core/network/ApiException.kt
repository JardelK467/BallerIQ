package org.example.balleriq.core.network


class ApiException(message: String, val code: Int? = null) : Exception(message)