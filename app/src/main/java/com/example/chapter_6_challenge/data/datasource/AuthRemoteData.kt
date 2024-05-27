package com.example.chapter_6_challenge.data.datasource

interface AuthRemoteData {
    suspend fun login(username: String, password: String): String
}