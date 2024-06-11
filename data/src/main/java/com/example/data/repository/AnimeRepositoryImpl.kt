package com.example.data.repository

import com.example.data.datasource.AnimeLocalData
import com.example.data.datasource.AnimeRemoteData
import com.example.data.mapper.toAnime
import com.example.data.mapper.toAnimeHome
import com.example.data.mapper.toAnimeEntity
import com.example.data.mapper.toAnimes
import com.example.domain.model.Anime
import com.example.domain.model.AnimeHome
import com.example.domain.repository.AnimeRepository

class AnimeRepositoryImpl(
    private val remoteData: AnimeRemoteData,
    private val localData: AnimeLocalData,
): AnimeRepository {
    override suspend fun fetchData(): List<AnimeHome> {
        return remoteData.fetchData()
    }

    override suspend fun fetchDataPlus(): List<Anime> {
        return remoteData.fetchDataPlus()
    }

    override suspend fun storeFavorite(anime: Anime) {
        localData.insertAnime(anime.toAnimeEntity())
    }

    override suspend fun deleteAnime(anime: Anime) {
        localData.deleteAnime(anime.toAnimeEntity())
    }

    override suspend fun getAllAnime(): List<Anime> {
        return localData.selectAllAnimes().toAnimes()
    }

    override suspend fun getMovieById(id: Int): Anime? {
        return localData.selectAnimeById(id)?.toAnime()
    }
}