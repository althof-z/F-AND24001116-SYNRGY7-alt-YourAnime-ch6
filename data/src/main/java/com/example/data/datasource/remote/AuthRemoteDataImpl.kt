package com.example.data.datasource.remote


import com.example.data.datasource.AuthRemoteData
import com.example.domain.model.User
import kotlinx.coroutines.delay

class AuthRemoteDataImpl : AuthRemoteData {

    private val users = listOf(
        User(
            userName = "aku",
            password = "aku",
        ),
    )

    override suspend fun login(username: String, password: String): String {
        delay(1000)
        if (users.contains(User(username, password))){
            return "abcdefghijklmnopqrstuvwxyz0987654321"
        } else {
            throw UnsupportedOperationException("Username or Password is incorrect")
        }
    }
}