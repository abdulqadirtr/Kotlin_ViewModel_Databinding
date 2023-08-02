package com.example.githubrepo_livedata.ui

sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class ErrorException(val exception: java.lang.Exception): Result<Nothing>()
    data class Error(
        val errorMessage: String,
    ) : Result<Nothing>()
}
