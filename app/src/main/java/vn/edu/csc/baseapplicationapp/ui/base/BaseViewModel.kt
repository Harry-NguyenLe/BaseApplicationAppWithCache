package vn.edu.csc.baseapplicationapp.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import vn.edu.csc.baseapplicationapp.rx.SchedulerProvider

abstract class BaseViewModel(application: Application, var schedulerProvider: SchedulerProvider) :
    AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()

    fun dispose(disposable: Disposable) {
        disposable.let {
            disposable.dispose()
        }
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}