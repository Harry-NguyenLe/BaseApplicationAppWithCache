package vn.edu.csc.baseapplicationapp.ui.demo

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import vn.edu.csc.baseapplicationapp.di.ViewModelKey
import vn.edu.csc.baseapplicationapp.di.scope.FragmentScope
import vn.edu.csc.baseapplicationapp.ui.dialog.LoadingDialog

@Module
abstract class UserModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun provideUserViewModel(userViewModel: UserViewModel): ViewModel

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun loadingDialog(): LoadingDialog?

}