package vn.edu.csc.baseapplicationapp.di.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import vn.edu.csc.baseapplicationapp.data.local.AppDatabase
import vn.edu.csc.baseapplicationapp.data.local.UserDao
import javax.inject.Singleton

@Module
class DBModule {
    @Singleton
    @Provides
    fun provideDb(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, "LocalDatabase.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): UserDao {
        return db.userDao()
    }
}