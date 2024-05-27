package com.example.chapter_6_challenge.data.datasource

import com.example.chapter_6_challenge.ui.fragments.data.Anime

interface AnimeRemoteData {

    suspend fun fetchData(): List<Anime>
}