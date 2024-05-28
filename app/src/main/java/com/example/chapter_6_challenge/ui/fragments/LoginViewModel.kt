package com.example.chapter_6_challenge.ui.fragments

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.savedstate.SavedStateRegistryOwner
import com.example.data.datasource.local.AuthLocalDataImpl
import com.example.data.datasource.local.dataStore
import com.example.data.datasource.remote.AuthRemoteDataImpl
import com.example.data.repository.AuthRepositoryImpl
import com.example.domain.repository.AuthRepository
import com.example.domain.usecases.LoginUsesCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUsesCase: LoginUsesCase
) : ViewModel() {


    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = _success

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = _error

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                loginUsesCase.login(username, password)
                _success.value = true
            } catch (throwable: Throwable) {
                _error.value = throwable
            }
        }
    }
}