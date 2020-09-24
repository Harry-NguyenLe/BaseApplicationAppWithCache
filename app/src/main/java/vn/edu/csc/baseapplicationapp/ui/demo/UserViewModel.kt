package vn.edu.csc.baseapplicationapp.ui.demo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import vn.edu.csc.baseapplicationapp.data.model.User
import vn.edu.csc.baseapplicationapp.data.repo.Resource
import vn.edu.csc.baseapplicationapp.domain.demo.UserUseCase
import vn.edu.csc.baseapplicationapp.rx.SchedulerProvider
import vn.edu.csc.baseapplicationapp.ui.base.BaseViewModel
import javax.inject.Inject

class UserViewModel @Inject constructor(
    application: Application,
    schedulerProvider: SchedulerProvider,
    private val userUseCase: UserUseCase
) : BaseViewModel(application, schedulerProvider) {

    private var _login = MutableLiveData<String?>()

    val user: LiveData<Resource<User>> = Transformations.switchMap(_login) {
        userUseCase.execute(Unit)
    }

    fun setLogIn() {
        _login.value = ""
    }
}