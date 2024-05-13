package com.example.chapter_5_challenge.data.datasource.mapper

import com.example.chapter_5_challenge.data.datasource.local.room.AnimeEntity
import com.example.chapter_5_challenge.data.datasource.remote.retrofit.model.anime.AnimeResponse
import com.example.chapter_5_challenge.ui.fragments.data.Anime

fun Anime.toAnimeEntity(): AnimeEntity{
    return AnimeEntity(
        id = id,
        image = image,
        title = title,
        desc = desc
    )
}

fun AnimeEntity.toAnime(): Anime{
    return Anime(
        id = id,
        image = image,
        title = title,
        desc = desc
    )
}

fun List<AnimeEntity>.toAnimes(): List<Anime>{
    return map { animeEntity -> animeEntity.toAnime() }
}

fun AnimeResponse.toAnime(): Anime{
    return Anime(
        id = malId,
        image = images.jpg.image_url,
        title = titleEnglish,
        desc = synopsis
    )
}