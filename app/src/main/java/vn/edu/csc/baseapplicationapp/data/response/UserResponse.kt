package vn.edu.csc.baseapplicationapp.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import vn.edu.csc.baseapplicationapp.data.model.User


data class UserResponse(
    @SerializedName("user")
    @Expose
    var user: User? = null
)