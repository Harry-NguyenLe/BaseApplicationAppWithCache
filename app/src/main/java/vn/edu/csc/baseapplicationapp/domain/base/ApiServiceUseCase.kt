package vn.edu.csc.baseapplicationapp.domain.base

import androidx.lifecycle.LiveData
import vn.edu.csc.baseapplicationapp.data.response.BaseResponse

abstract class ApiServiceUseCase<P, R> {
    abstract fun execute(param: P): LiveData<BaseResponse<R>>
}