package vn.edu.csc.baseapplicationapp.data.repo

import androidx.lifecycle.LiveData
import vn.edu.csc.baseapplicationapp.AppExecutors
import vn.edu.csc.baseapplicationapp.data.cache.NetworkBoundResource
import vn.edu.csc.baseapplicationapp.data.local.UserDao
import vn.edu.csc.baseapplicationapp.data.model.User
import vn.edu.csc.baseapplicationapp.data.remote.ApiService
import vn.edu.csc.baseapplicationapp.data.response.ApiResponse
import vn.edu.csc.baseapplicationapp.data.response.ApiSuccessResponse
import vn.edu.csc.baseapplicationapp.data.response.UserResponse
import vn.edu.csc.baseapplicationapp.utilities.RateLimiter
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val appExecutors: AppExecutors,
    private val userDao: UserDao,
    private val apiService: ApiService
) : UserRepository {

    private val repoListRateLimiter = RateLimiter<String>(1, TimeUnit.MINUTES)

    override fun getUser(): LiveData<Resource<User>> {
        return object : NetworkBoundResource<User, UserResponse>(appExecutors) {
            override fun saveCallResult(item: UserResponse) {
                userDao.insert(item.user!!)
            }

            override fun shouldFetch(resultData: User?): Boolean {
                return resultData == null
            }

            override fun loadFromDb(): LiveData<User> = userDao.findByLogin()

            override fun createCall(): LiveData<ApiResponse<UserResponse>> = apiService.getUser()

            override fun onFetchFailed() {
                repoListRateLimiter.reset("")
            }

            override fun processResponse(response: ApiSuccessResponse<UserResponse>): UserResponse {
                return response.body
            }
        }.asLiveData()
    }
}