package vn.edu.csc.baseapplicationapp.data.response

import com.google.gson.annotations.SerializedName

abstract class BaseResponse<T> {
    @SerializedName("message")
    lateinit var message: String

    @SerializedName("code")
    var code: Int = 0

    @SerializedName("data")
    lateinit var data: ArrayList<T>
}

