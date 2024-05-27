package com.example.chapter_6_challenge.data.datasource.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.chapter_6_challenge.data.datasource.AuthLocalData
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class AuthLocalDataImpl(
    private val dataStore: DataStore<Preferences>,
) : AuthLocalData {

    companion object {
        const val KEY_TOKEN = "TOKEN"
        private val AUTH_TOKEN_KEY = stringPreferencesKey(KEY_TOKEN)
    }

    override suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[AUTH_TOKEN_KEY] = token
        }
    }

    override suspend fun loadToken(): String? {
        return dataStore.data.map { preferences ->
            preferences[AUTH_TOKEN_KEY]
        }.firstOrNull()
    }

    override suspend fun clearToken() {
        dataStore.edit { preferences ->
            preferences[AUTH_TOKEN_KEY] = ""
        }
    }
}