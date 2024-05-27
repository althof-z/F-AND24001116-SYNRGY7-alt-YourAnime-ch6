package com.example.domain.repository

interface AuthRepository {

    suspend fun login(username: String, password: String): String
    suspend fun saveToken(token: String)
    suspend fun loadToken(): String?
    suspend fun clearToken()
}