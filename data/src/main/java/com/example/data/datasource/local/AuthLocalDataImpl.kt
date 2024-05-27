package com.example.data.datasource.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.data.datasource.AuthLocalData
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class AuthLocalDataImpl(
    private val dataStore: DataStore<Preferences>,
) : com.example.data.datasource.AuthLocalData {

    companion object {
        const val KEY_TOKEN = "TOKEN"
        private val AUTH_TOKEN_KEY = stringPreferencesKey(com.example.data.datasource.local.AuthLocalDataImpl.Companion.KEY_TOKEN)
    }

    override suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[com.example.data.datasource.local.AuthLocalDataImpl.Companion.AUTH_TOKEN_KEY] = token
        }
    }

    override suspend fun loadToken(): String? {
        return dataStore.data.map { preferences ->
            preferences[com.example.data.datasource.local.AuthLocalDataImpl.Companion.AUTH_TOKEN_KEY]
        }.firstOrNull()
    }

    override suspend fun clearToken() {
        dataStore.edit { preferences ->
            preferences[com.example.data.datasource.local.AuthLocalDataImpl.Companion.AUTH_TOKEN_KEY] = ""
        }
    }
}