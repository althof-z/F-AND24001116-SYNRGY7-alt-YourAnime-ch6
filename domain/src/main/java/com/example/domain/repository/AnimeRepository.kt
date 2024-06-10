package com.example.domain.repository

import com.example.domain.model.Anime
import com.example.domain.model.AnimeHome

interface AnimeRepository {

    suspend fun fetchData(): List<AnimeHome>

    suspend fun fetchDataPlus(): List<Anime>

    suspend fun storeFavorite(anime: Anime)

    suspend fun getAllAnime(): List<Anime>

    suspend fun deleteAnime(anime: Anime)

    suspend fun getMovieById(id: Int): Anime?
}