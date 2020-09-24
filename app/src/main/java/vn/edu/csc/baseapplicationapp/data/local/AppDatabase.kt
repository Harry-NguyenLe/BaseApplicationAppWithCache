package vn.edu.csc.baseapplicationapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import vn.edu.csc.baseapplicationapp.data.model.User

@Database(
    entities = [
        User::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}