package com.ragabz.rawg.initializer

import android.content.Context
import androidx.startup.Initializer
import com.ragabz.rawg.BuildConfig
import timber.log.Timber

class TimberInitializer : Initializer<Unit> {
    override fun create(context: Context): Unit {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Timber.d("TimberInitializer --> initialized")
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()
}