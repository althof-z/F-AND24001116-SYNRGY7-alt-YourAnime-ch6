package com.example.chapter_6_challenge.data.datasource.remote

import com.example.chapter_6_challenge.data.datasource.AnimeRemoteData
import com.example.chapter_6_challenge.data.datasource.mapper.toAnime
import com.example.chapter_6_challenge.data.datasource.remote.retrofit.JikanService
import com.example.chapter_6_challenge.ui.fragments.data.Anime

class AnimeRemoteDataImpl(
    private val jikanService: JikanService,
): AnimeRemoteData {
    override suspend fun fetchData(): List<Anime> {
        return jikanService.getTrendingAnime().data.map { it.toAnime() }
    }
}