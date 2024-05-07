package com.example.chapter_5_challenge.data.datasource

interface AuthLocalData {
    fun saveToken(token: String)
    fun loadToken(): String?
    fun clearToken()
}