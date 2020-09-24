package vn.edu.csc.baseapplicationapp.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import vn.edu.csc.baseapplicationapp.EnvironmentManager
import vn.edu.csc.baseapplicationapp.rx.AppSchedulerProvider
import vn.edu.csc.baseapplicationapp.rx.SchedulerProvider
import javax.inject.Named
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    @Named(Qualifiers.ENVIRONMENT)
    fun provideBaseURL(): String {
        return when (EnvironmentManager.env) {
            EnvironmentManager.ENV.DEV -> EnvironmentManager.DEV_BASE_URL
            EnvironmentManager.ENV.TEST -> EnvironmentManager.TEST_BASE_URL
            EnvironmentManager.ENV.SANDBOX -> EnvironmentManager.SANDBOX_BASE_URL
            EnvironmentManager.ENV.STAGING -> EnvironmentManager.STAGING_BASE_URL
            EnvironmentManager.ENV.PRODUCTION -> EnvironmentManager.PRODUCTION_BASE_URL
        }
    }
}