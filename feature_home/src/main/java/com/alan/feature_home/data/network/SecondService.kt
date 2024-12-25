package com.alan.feature_home.data.network

import retrofit2.http.GET

interface SecondService {
    @GET("endpoint2")
    suspend fun getSecondData(): String
}
