package com.example.chapter_5_challenge.data.datasource

import com.example.chapter_5_challenge.ui.fragments.data.Anime

interface AnimeRemoteData {

    suspend fun fetchData(): List<Anime>
}