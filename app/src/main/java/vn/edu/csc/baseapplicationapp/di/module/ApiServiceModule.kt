package vn.edu.csc.baseapplicationapp.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import vn.edu.csc.baseapplicationapp.data.remote.ApiService
import javax.inject.Singleton

@Module
class ApiServiceModule {

    @Singleton
    @Provides
    fun clientInterface(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}