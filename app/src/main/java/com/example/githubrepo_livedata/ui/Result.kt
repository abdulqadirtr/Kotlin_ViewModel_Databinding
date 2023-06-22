package com.example.githubrepo_livedata.ui

sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(
        val exception: Exception,
        val errorMessage: String,
    ) : Result<Nothing>()

}
