package com.example.data.datasource.remote

import com.example.data.datasource.remote.retrofit.JikanService
import com.example.data.mapper.toAnime
import com.example.domain.model.Anime

class AnimeRemoteDataImpl(
    private val jikanService: JikanService,
): com.example.data.datasource.AnimeRemoteData {
    override suspend fun fetchData(): List<Anime> {
        return jikanService.getTrendingAnime().data.map { it.toAnime() }
    }
}