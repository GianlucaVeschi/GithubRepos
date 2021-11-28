package com.gianlucaveschi.githubrepos.ui.main

import android.app.Application
import com.gianlucaveschi.githubrepos.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}