package vn.edu.csc.baseapplicationapp.domain.base

import androidx.lifecycle.LiveData
import vn.edu.csc.baseapplicationapp.data.repo.Resource

abstract class LocalUseCase<P, R> {
    abstract fun execute(param: P): LiveData<Resource<R>>
}