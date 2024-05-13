package com.example.chapter_5_challenge.data.datasource.remote

import com.example.chapter_5_challenge.data.datasource.AnimeRemoteData
import com.example.chapter_5_challenge.data.datasource.remote.retrofit.JikanService
import com.example.chapter_5_challenge.data.datasource.remote.retrofit.model.toAnime
import com.example.chapter_5_challenge.ui.fragments.data.Anime

class AnimeRemoteDataImpl(
    private val jikanService: JikanService,
): AnimeRemoteData {
    override suspend fun fetchData(): List<Anime> {
        return jikanService.getTrendingAnime().data.map { it.toAnime() }
    }
}