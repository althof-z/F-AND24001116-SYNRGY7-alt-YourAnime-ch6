package com.example.chapter_6_challenge.domain

import com.example.chapter_6_challenge.ui.fragments.data.Anime

interface AnimeRepository {

    suspend fun fetchData(): List<Anime>

    suspend fun storeFavorite(anime: Anime)

    suspend fun getAllAnime(): List<Anime>

    suspend fun deleteAnime(anime: Anime)

    suspend fun getMovieById(id: Int): Anime?
}