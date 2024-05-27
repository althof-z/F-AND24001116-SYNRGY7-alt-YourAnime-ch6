package com.example.data.datasource

import com.example.domain.model.Anime

interface AnimeRemoteData {

    suspend fun fetchData(): List<Anime>
}