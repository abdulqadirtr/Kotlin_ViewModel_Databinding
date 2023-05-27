package com.example.githubrepo_livedata.data

import java.lang.Exception
import kotlin.Result

sealed class Result2<out T> {
    data class Success<out R>(val value: R): Result2<R>()
    data class Failure(
        val message: String?,
        val throwable: Throwable?
    ): Result2<Nothing>()
}