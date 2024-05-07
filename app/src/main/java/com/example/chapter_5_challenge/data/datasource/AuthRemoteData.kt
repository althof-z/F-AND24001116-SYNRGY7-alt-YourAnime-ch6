package com.example.chapter_5_challenge.data.datasource

interface AuthRemoteData {
    suspend fun login(username: String, password: String): String
}