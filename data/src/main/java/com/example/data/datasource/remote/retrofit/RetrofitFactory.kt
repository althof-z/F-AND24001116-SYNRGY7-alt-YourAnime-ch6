package com.example.data.datasource.remote.retrofit

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private fun provideRetrofit(context: Context, baseUrl: String): Retrofit{
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(provideOkHttpClient(context))
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()
}

private fun provideOkHttpClient(context: Context): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS) // Set connection timeout
        .readTimeout(30, TimeUnit.SECONDS)    // Set read timeout
        .writeTimeout(30, TimeUnit.SECONDS)   // Set write timeout
        .addInterceptor(provideHttpLoggingInterceptor())
        .addInterceptor(provideChuckerInterceptor(context))
        .build()
}

private fun provideHttpLoggingInterceptor(): Interceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return httpLoggingInterceptor
}

private fun provideChuckerInterceptor(context: Context): Interceptor {
    return ChuckerInterceptor.Builder(context).build()
}


fun provideJikanService(context: Context): JikanService{
    return provideRetrofit(
        context,
        "https://api.jikan.moe/v4/",
    ).create(JikanService::class.java)
}

