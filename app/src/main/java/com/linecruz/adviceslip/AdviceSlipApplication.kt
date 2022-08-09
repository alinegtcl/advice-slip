package com.linecruz.adviceslip

import android.app.Application
import com.linecruz.adviceslip.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AdviceSlipApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@AdviceSlipApplication)
            modules(appModules)
        }
    }

}