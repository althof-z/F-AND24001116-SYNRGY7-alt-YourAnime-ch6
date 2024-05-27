package com.example.chapter_6_challenge.domain.usecases

import com.example.chapter_6_challenge.domain.AuthRepository

class LoginUsesCase(
    private val repository: AuthRepository
) {
    suspend fun login(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            throw IllegalArgumentException("Username or password cannot be empty")
        } else {
            val token = repository.login(username, password)
            repository.saveToken(token)
        }
    }
}