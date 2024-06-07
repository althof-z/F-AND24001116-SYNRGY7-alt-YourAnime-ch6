package com.example.data.datasource.remote

import com.example.data.datasource.remote.retrofit.JikanService
import com.example.data.mapper.toAnime
import com.example.data.mapper.toAnimeHome
import com.example.domain.model.Anime
import com.example.domain.model.AnimeHome

class AnimeRemoteDataImpl(
    private val jikanService: JikanService,
): com.example.data.datasource.AnimeRemoteData {
    override suspend fun fetchData(): List<AnimeHome> {
        return jikanService.getTrendingAnime().data.map { it.toAnimeHome() }
    }

    override suspend fun fetchDataPlus(): List<Anime> {
        return jikanService.getTrendingAnime().data.map { it.toAnime() }
    }
}