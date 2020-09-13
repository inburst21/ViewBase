package io.neverstoplearning.advancedandroid.base

import android.app.Application

class BaseApplication: Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(
                        ApplicationModule(this))
                .build()

    }
}