package com.example.githubrepo_livedata.dagger

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.internal.managers.ApplicationComponentManager

@HiltAndroidApp
class MyApplication : Application() {
    // A method to get the ApplicationComponent

}