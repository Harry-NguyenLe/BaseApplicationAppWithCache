package vn.edu.csc.baseapplicationapp.data.remote

import androidx.lifecycle.LiveData
import retrofit2.http.GET
import vn.edu.csc.baseapplicationapp.data.response.ApiResponse
import vn.edu.csc.baseapplicationapp.data.response.UserResponse

interface ApiService {
    @GET("v3/48d6d3ca-3e87-4805-8abc-667e2874995b")
    fun getUser(): LiveData<ApiResponse<UserResponse>>
}