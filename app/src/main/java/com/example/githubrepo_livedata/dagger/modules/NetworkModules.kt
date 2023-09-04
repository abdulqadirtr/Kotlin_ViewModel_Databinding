package com.example.githubrepo_livedata.dagger.modules

import com.example.githubrepo_livedata.Network.ApiEndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModules {

    val baseUrl = "https://api.github.com/"
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(baseUrl) // Replace with your base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiEndPoint? {
        return retrofit.create(ApiEndPoint::class.java)
    }
}
