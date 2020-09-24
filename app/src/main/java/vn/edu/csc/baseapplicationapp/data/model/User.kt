package vn.edu.csc.baseapplicationapp.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(primaryKeys = ["id"])
data class User(
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("name")
    val name: String?,
)