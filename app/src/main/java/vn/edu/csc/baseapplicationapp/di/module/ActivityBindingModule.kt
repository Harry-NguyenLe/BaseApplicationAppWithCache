package vn.edu.csc.baseapplicationapp.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.edu.csc.baseapplicationapp.di.scope.ActivityScope
import vn.edu.csc.baseapplicationapp.ui.demo.MainActivity
import vn.edu.csc.baseapplicationapp.ui.demo.UserModule

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            UserModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity

}