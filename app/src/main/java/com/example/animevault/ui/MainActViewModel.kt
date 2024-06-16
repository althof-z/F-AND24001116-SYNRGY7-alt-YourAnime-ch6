package com.example.animevault.ui

import androidx.lifecycle.ViewModel
import com.example.domain.repository.AuthRepository

class MainActViewModel(
    private val authRepository: AuthRepository
): ViewModel()