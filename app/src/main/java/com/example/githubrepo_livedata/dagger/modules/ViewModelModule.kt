package com.example.githubrepo_livedata.dagger.modules

import com.example.githubrepo_livedata.data.GithubRepository
import com.example.githubrepo_livedata.viewModel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideMainViewModel(repository: GithubRepository): MainViewModel {
        return MainViewModel(repository)
    }
}