package com.example.data.datasource

import com.example.domain.model.Anime
import com.example.domain.model.AnimeHome

interface AnimeRemoteData {

    suspend fun fetchData(): List<AnimeHome>

    suspend fun fetchDataPlus(): List<Anime>
}