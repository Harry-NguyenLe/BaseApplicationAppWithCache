package vn.edu.csc.baseapplicationapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import vn.edu.csc.baseapplicationapp.AppController
import vn.edu.csc.baseapplicationapp.di.module.*
import javax.inject.Singleton

@Singleton
@Component
    (
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        LocalModule::class,
        DBModule::class,
        ViewModelModule::class,
        RepoModule::class,
        ApiServiceModule::class,
        ActivityBindingModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<AppController> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}