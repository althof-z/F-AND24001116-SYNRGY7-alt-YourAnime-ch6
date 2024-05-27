package com.example.data.datasource

interface AuthRemoteData {
    suspend fun login(username: String, password: String): String
}