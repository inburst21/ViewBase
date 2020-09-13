package io.neverstoplearning.advancedandroid.base

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    fun providesApplicationContext(): Context {
        return application
    }
}