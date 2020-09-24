package vn.edu.csc.baseapplicationapp.di.module

import dagger.Binds
import dagger.Module
import vn.edu.csc.baseapplicationapp.data.repo.UserRepository
import vn.edu.csc.baseapplicationapp.data.repo.UserRepositoryImpl
import javax.inject.Singleton

@Module
abstract class RepoModule {

    @Singleton
    @Binds
    abstract fun userRepo(userRepositoryImpl: UserRepositoryImpl): UserRepository

}