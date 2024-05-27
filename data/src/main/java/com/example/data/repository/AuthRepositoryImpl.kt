package com.example.data.repository

import com.example.data.datasource.AuthLocalData
import com.example.data.datasource.AuthRemoteData
import com.example.domain.repository.AuthRepository


class AuthRepositoryImpl(
    private val authLocalData: AuthLocalData,
    private val authRemoteData: AuthRemoteData,
) : AuthRepository {
    override suspend fun login(username: String, password: String): String {
        return authRemoteData.login(username, password)
    }

    override suspend fun saveToken(token: String) {
        authLocalData.saveToken(token)
    }

    override suspend fun loadToken(): String? {
        return authLocalData.loadToken()
    }

    override suspend fun clearToken() {
        authLocalData.clearToken()
    }
}