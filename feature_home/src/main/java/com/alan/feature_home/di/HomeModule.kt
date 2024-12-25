package com.alan.feature_home.di

import com.alan.core.di.NetworkModule
import com.alan.feature_home.data.network.FirstService
import com.alan.feature_home.data.network.SecondService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class HomeModule {

    @Provides
    fun provideFirstService(@NetworkModule.FirstServer retrofit: Retrofit): FirstService {
        return retrofit.create(FirstService::class.java)
    }

    @Provides
    fun provideSecondService(@NetworkModule.SecondServer retrofit: Retrofit): SecondService {
        return retrofit.create(SecondService::class.java)
    }
}
