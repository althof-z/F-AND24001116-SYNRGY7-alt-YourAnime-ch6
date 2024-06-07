package com.example.domain.repository

import com.example.domain.model.Anime
import com.example.domain.model.AnimeHome

interface AnimeRepository {

    suspend fun fetchData(): List<AnimeHome>

    suspend fun fetchDataPlus(): List<Anime>

    suspend fun storeFavorite(animeHome: AnimeHome)

    suspend fun getAllAnime(): List<AnimeHome>

    suspend fun deleteAnime(animeHome: AnimeHome)

    suspend fun getMovieById(id: Int): AnimeHome?
}