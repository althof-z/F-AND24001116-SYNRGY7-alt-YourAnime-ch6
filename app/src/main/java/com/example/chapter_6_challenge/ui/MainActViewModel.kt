package com.example.chapter_6_challenge.ui

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.data.datasource.local.AuthLocalDataImpl
import com.example.data.datasource.local.dataStore
import com.example.data.datasource.remote.AuthRemoteDataImpl
import com.example.data.repository.AuthRepositoryImpl
import com.example.domain.repository.AuthRepository

class MainActViewModel(
    private val authRepository: AuthRepository
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
                    val authRepository: AuthRepository =
                        AuthRepositoryImpl(
                            authLocalData = AuthLocalDataImpl(
                                dataStore = context.dataStore,
                            ),
                            authRemoteData = AuthRemoteDataImpl(),
                        )
                    return MainActViewModel(authRepository = authRepository) as T
                }
            }
    }

}