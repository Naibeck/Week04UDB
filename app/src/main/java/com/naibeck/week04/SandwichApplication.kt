package com.naibeck.week04

import android.app.Application
import timber.log.Timber

class SandwichApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}