package com.example.chapter_5_challenge.ui.fragments

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.savedstate.SavedStateRegistryOwner
import com.example.chapter_5_challenge.data.datasource.local.AuthLocalDataImpl
import com.example.chapter_5_challenge.data.datasource.local.SharedPreferencesFactory
import com.example.chapter_5_challenge.data.datasource.local.dataStore
import com.example.chapter_5_challenge.data.datasource.remote.AuthRemoteDataImpl
import com.example.chapter_5_challenge.data.repository.AuthRepositoryImpl
import com.example.chapter_5_challenge.domain.AuthRepository
import kotlinx.coroutines.launch

class FirstFragViewModel ( private val authRepository: AuthRepository
): ViewModel() {
    companion object {
        fun provideFactory(
            owner: SavedStateRegistryOwner,
            context: Context,
        ): AbstractSavedStateViewModelFactory =
            object : AbstractSavedStateViewModelFactory(owner, null) {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle,
                ): T {
                    val authRepository: AuthRepository = AuthRepositoryImpl(
                        authLocalData = AuthLocalDataImpl(
                            dataStore = context.dataStore
                        ),
                        authRemoteData = AuthRemoteDataImpl(),
                    )
                    return FirstFragViewModel(authRepository = authRepository) as T
                }
            }
    }

    private val _isAuthed = MutableLiveData<Boolean>()
    val isAuthed: LiveData<Boolean> = _isAuthed

    fun checkLogin() {
        viewModelScope.launch {
            try {
                _isAuthed.value = !authRepository.loadToken().isNullOrEmpty()
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
            }
        }
    }
}