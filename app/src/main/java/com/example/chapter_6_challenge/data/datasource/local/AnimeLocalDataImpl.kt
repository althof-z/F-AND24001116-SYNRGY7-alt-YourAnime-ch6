package com.example.chapter_6_challenge.data.datasource.local

import com.example.chapter_6_challenge.data.datasource.AnimeLocalData
import com.example.chapter_6_challenge.data.datasource.local.room.AnimeDao
import com.example.chapter_6_challenge.data.datasource.local.room.AnimeEntity

class AnimeLocalDataImpl(
    private val animeDao: AnimeDao,
): AnimeLocalData {


    override suspend fun insertAnime(animeEntity: AnimeEntity) {
        animeDao.insertAnime(animeEntity)
    }

    override suspend fun deleteAnime(animeEntity: AnimeEntity) {
        animeDao.deleteAnime(animeEntity)
    }

    override suspend fun selectAnimeById(id: Int): AnimeEntity? {
        return animeDao.selectAnimeById(id)
    }

    override suspend fun selectAllAnimes(): List<AnimeEntity> {
       return animeDao.selectAllAnimes()
    }
}