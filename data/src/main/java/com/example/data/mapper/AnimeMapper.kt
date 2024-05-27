package com.example.data.mapper

import com.example.data.datasource.local.room.AnimeEntity
import com.example.data.datasource.remote.retrofit.model.anime.AnimeResponse
import com.example.domain.model.Anime

fun Anime.toAnimeEntity(): AnimeEntity {
    return AnimeEntity(
        id = id,
        image = image,
        title = title,
        desc = desc
    )
}

fun AnimeEntity.toAnime(): Anime {
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

fun AnimeResponse.toAnime(): Anime {
    return Anime(
        id = malId,
        image = images.jpg.image_url,
        title = titleEnglish,
        desc = synopsis
    )
}