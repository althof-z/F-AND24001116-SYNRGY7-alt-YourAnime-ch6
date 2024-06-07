package com.example.data.mapper

import com.example.data.datasource.local.room.AnimeEntity
import com.example.data.datasource.remote.retrofit.model.anime.AnimeResponse
import com.example.domain.model.Anime
import com.example.domain.model.AnimeHome

fun AnimeHome.toAnimeEntity(): AnimeEntity {
    return AnimeEntity(
        id = id,
        image = image,
        title = title,
        desc = desc
    )
}

fun AnimeEntity.toAnimeHome(): AnimeHome {
    return AnimeHome(
        id = id,
        image = image,
        title = title,
        desc = desc
    )
}

fun List<AnimeEntity>.toAnimes(): List<AnimeHome>{
    return map { animeEntity -> animeEntity.toAnimeHome() }
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