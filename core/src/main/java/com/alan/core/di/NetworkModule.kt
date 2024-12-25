package com.alan.core.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class NetworkModule {
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class FirstServer

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class SecondServer

    @Singleton
    @Provides
    @FirstServer
    fun provideFirstRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://1.com/")
            .build()
    }

    @Singleton
    @Provides
    @SecondServer
    fun provideSecondRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://2.com/")
            .build()
    }
}
