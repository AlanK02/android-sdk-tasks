package com.alan.feature_home.data.network

import retrofit2.http.GET

interface FirstService {
    @GET("endpoint1")
    suspend fun getFirstData(): String
}
