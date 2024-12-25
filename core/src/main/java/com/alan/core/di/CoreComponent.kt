package com.alan.core.di

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface CoreComponent {
    @NetworkModule.FirstServer
    fun getFirstRetrofit(): Retrofit

    @NetworkModule.SecondServer
    fun getSecondRetrofit(): Retrofit
}
