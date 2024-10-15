package com.balleriq.utils

import com.balleriq.network.ApiResponse

inline fun <T, R> handleResponse(
    response: ApiResponse<T>,
    onSuccess: (T) -> R,
    onError: (String, Int) -> Nothing,
): T {
    return when (response) {
        is ApiResponse.Success -> response.data
        is ApiResponse.Error -> onError(response.message!!, response.code!!)
    }
}
