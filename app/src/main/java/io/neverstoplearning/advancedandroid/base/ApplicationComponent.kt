package io.neverstoplearning.advancedandroid.base

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class
])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent
        fun applicationModule(applicationModule: ApplicationModule): Builder
    }
}