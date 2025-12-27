package com.samedtemiz.subcatcher

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class for SubCatcher
 * Initializes Hilt dependency injection
 */
@HiltAndroidApp
class SubCatcherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}

