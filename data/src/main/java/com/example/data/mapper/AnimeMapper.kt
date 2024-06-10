package com.example.data.mapper

import com.example.data.datasource.local.room.AnimeEntity
import com.example.data.datasource.remote.retrofit.model.anime.AnimeResponse
import com.example.domain.model.Anime
import com.example.domain.model.AnimeHome

fun Anime.toAnimeEntity(): AnimeEntity {
    return AnimeEntity(
        id = id,
        image = image,
        title = title,
        synopsis = synopsis,
        year = year,
        episode = episode,
        rate = rate
    )
}

fun AnimeEntity.toAnime(): Anime{
    return Anime(
        id = id,
        image = image,
        title = title,
        synopsis = synopsis,
        year = year,
        episode = episode,
        rate = rate
    )
}

fun List<AnimeEntity>.toAnimes(): List<Anime>{
    return map { animeEntity -> animeEntity.toAnime() }
}

fun AnimeResponse.toAnimeHome(): AnimeHome {
    return AnimeHome(
        id = malId,
        image = images.jpg.image_url,
        title = titleEnglish,
        desc = "$year • $episodes episodes"
    )
}

fun AnimeResponse.toAnime(): Anime{
    return Anime(
        id = malId,
        image = images.jpg.image_url,
        title = titleEnglish,
        synopsis = synopsis,
        year = year,
        episode = "$episodes episodes",
        rate = score
    )
}