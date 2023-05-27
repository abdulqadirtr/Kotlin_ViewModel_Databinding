package com.example.githubrepo_livedata.data

sealed class Result3<out T : Any>()
{
    data class Success<out T : Any>(val data: T) : Result3<T>()
    data class Error(val exception: Exception) : Result3<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}
