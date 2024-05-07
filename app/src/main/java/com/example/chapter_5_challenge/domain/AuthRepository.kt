package com.example.chapter_5_challenge.domain

interface AuthRepository {

    suspend fun login(username: String, password: String): String
    fun saveToken(token: String)
    fun loadToken(): String?
    fun clearToken()
}