package com.linecruz.adviceslip.domain.utils

sealed class Result<out S, out E> {
    data class Success<out S>(val data: S) : Result<S, Nothing>()
    data class Error<out E>(val failure: E) : Result<Nothing, E>()
}

inline fun <S, E, R> Result<S, E>.flow(
    success: (S) -> R,
    error: (E) -> R
): R {
    return when (this) {
        is Result.Success -> success(data)
        is Result.Error -> error(failure)
    }
}