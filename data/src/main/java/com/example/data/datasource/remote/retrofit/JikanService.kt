package com.example.data.datasource.remote.retrofit

import com.example.data.datasource.remote.retrofit.model.JikanResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface JikanService {
    @GET("top/anime")
    @Headers("Content-Type: application/json")
    suspend fun getTrendingAnime(): JikanResponse
}