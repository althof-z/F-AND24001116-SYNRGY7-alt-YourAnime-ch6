package com.example.data.datasource

interface AuthLocalData {
    suspend fun saveToken(token: String)
    suspend fun loadToken(): String?
    suspend fun clearToken()
}