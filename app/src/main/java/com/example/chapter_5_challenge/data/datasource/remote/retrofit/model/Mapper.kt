package com.example.chapter_5_challenge.data.datasource.remote.retrofit.model

import com.example.chapter_5_challenge.data.datasource.remote.retrofit.model.anime.AnimeResponse
import com.example.chapter_5_challenge.ui.fragments.data.Anime

fun AnimeResponse.toAnime(): Anime{
    return Anime(
        id = malId,
        title = titleEnglish,
    )
}