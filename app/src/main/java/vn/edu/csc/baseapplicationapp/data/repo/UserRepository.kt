package vn.edu.csc.baseapplicationapp.data.repo

import androidx.lifecycle.LiveData
import vn.edu.csc.baseapplicationapp.data.model.User

interface UserRepository {
    fun getUser(): LiveData<Resource<User>>
}