package com.example.githubrepo_livedata.data

//changed this to Generic now and can accept list as well
sealed class Result3<out T : Any>() {

    data class Success<T : Any>(val data: T) : Result3<T>()
    data class Error(val exception: Exception) : Result3<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}
