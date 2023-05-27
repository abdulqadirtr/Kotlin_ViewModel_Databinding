package com.example.githubrepo_livedata.data

import java.lang.Exception

sealed class Result<T>(val data : T?= null, val errorMessage: String? =null) {

    //data class Loading<out T: Any>() : Result<T>()
     class Success<T>(data: T? = null) : Result<T>(data=data)
     class Error<T>(errorMessage: String) : Result<T>(errorMessage=errorMessage)

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$errorMessage]"
        }
    }
}