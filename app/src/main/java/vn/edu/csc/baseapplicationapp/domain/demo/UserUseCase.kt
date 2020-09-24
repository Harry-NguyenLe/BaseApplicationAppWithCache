package vn.edu.csc.baseapplicationapp.domain.demo

import androidx.lifecycle.LiveData
import vn.edu.csc.baseapplicationapp.data.model.User
import vn.edu.csc.baseapplicationapp.data.repo.Resource
import vn.edu.csc.baseapplicationapp.data.repo.UserRepository
import vn.edu.csc.baseapplicationapp.domain.base.LocalUseCase
import javax.inject.Inject

class UserUseCase
@Inject constructor(
    private val userRepository: UserRepository
) : LocalUseCase<Unit, User>() {

    override fun execute(param: Unit): LiveData<Resource<User>> {
        return userRepository.getUser()
    }
}