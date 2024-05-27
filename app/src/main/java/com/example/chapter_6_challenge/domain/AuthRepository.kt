package com.example.chapter_6_challenge.domain

interface AuthRepository {

    suspend fun login(username: String, password: String): String
    suspend fun saveToken(token: String)
    suspend fun loadToken(): String?
    suspend fun clearToken()
}