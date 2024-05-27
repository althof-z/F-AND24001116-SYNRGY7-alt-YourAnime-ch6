package com.example.domain.repository

import com.example.domain.model.Anime

interface AnimeRepository {

    suspend fun fetchData(): List<Anime>

    suspend fun storeFavorite(anime: Anime)

    suspend fun getAllAnime(): List<Anime>

    suspend fun deleteAnime(anime: Anime)

    suspend fun getMovieById(id: Int): Anime?
}