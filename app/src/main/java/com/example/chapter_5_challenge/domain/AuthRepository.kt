package com.example.chapter_5_challenge.domain

interface AuthRepository {

    suspend fun login(username: String, password: String): String
    suspend fun saveToken(token: String)
    suspend fun loadToken(): String?
    suspend fun clearToken()
}