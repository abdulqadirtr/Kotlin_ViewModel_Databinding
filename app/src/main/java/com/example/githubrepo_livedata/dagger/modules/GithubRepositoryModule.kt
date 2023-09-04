package com.example.githubrepo_livedata.dagger.modules

import com.example.githubrepo_livedata.data.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class) // or other appropriate component
object GithubRepositoryModule {

    @Provides
    fun provideGithubRepository(): GithubRepository {
        return GithubRepository() // or however you create it
    }
}