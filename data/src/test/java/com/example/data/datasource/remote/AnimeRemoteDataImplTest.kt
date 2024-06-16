package com.example.data.datasource.remote

import com.example.data.datasource.remote.retrofit.JikanService
import com.example.data.datasource.remote.retrofit.model.JikanResponse
import com.example.data.datasource.remote.retrofit.model.anime.AnimeResponse
import com.example.data.datasource.remote.retrofit.model.anime.Images
import com.example.data.datasource.remote.retrofit.model.anime.Jpg
import com.example.data.datasource.remote.retrofit.model.anime.Webp
import com.example.data.mapper.toAnime
import com.example.data.mapper.toAnimeHome
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class AnimeRemoteDataImplTest {

    //given
    private val jikanService = mock<JikanService>()
    private val dataSource = AnimeRemoteDataImpl(
        jikanService = jikanService,
    )

    @Test
    fun fetchDataTest() = runTest {
        // Arrange
        val mockAnimeResponseList = listOf(
            AnimeResponse(
                airing = false,
                approved = true,
                background = "Background 1",
                demographics = emptyList(),
                duration = "24 min",
                episodes = 12,
                explicit_genres = emptyList(),
                favorites = 100,
                genres = emptyList(),
                images = Images(
                    jpg = Jpg(
                        image_url = "http://example.com/image1.jpg",
                        large_image_url = "http://example.com/large_image1.jpg",
                        small_image_url = "http://example.com/small_image1.jpg"
                    ),
                    webp = Webp(
                        image_url = "http://example.com/image1.webp",
                        large_image_url = "http://example.com/large_image1.webp",
                        small_image_url = "http://example.com/small_image1.webp"
                    )
                ),
                licensors = emptyList(),
                malId = 1,
                members = 1000,
                popularity = 500,
                producers = emptyList(),
                rank = 1,
                rating = "PG-13",
                score = 8.5,
                scored_by = 200,
                season = "Fall",
                source = "Manga",
                status = "Finished Airing",
                studios = emptyList(),
                synopsis = "Synopsis 1",
                themes = emptyList(),
                title = "Anime 1",
                titleEnglish = "Anime 1 English",
                title_japanese = "アニメ 1",
                title_synonyms = listOf("Synonym 1"),
                titles = emptyList(),
                type = "TV",
                url = "http://example.com/anime1",
                year = 2020
            ),
            AnimeResponse(
                airing = false,
                approved = true,
                background = "Background 2",
                demographics = emptyList(),
                duration = "24 min",
                episodes = 24,
                explicit_genres = emptyList(),
                favorites = 200,
                genres = emptyList(),
                images = Images(
                    jpg = Jpg(
                        image_url = "http://example.com/image2.jpg",
                        large_image_url = "http://example.com/large_image2.jpg",
                        small_image_url = "http://example.com/small_image2.jpg"
                    ),
                    webp = Webp(
                        image_url = "http://example.com/image2.webp",
                        large_image_url = "http://example.com/large_image2.webp",
                        small_image_url = "http://example.com/small_image2.webp"
                    )
                ),
                licensors = emptyList(),
                malId = 2,
                members = 2000,
                popularity = 400,
                producers = emptyList(),
                rank = 2,
                rating = "PG-13",
                score = 9.0,
                scored_by = 300,
                season = "Spring",
                source = "Light Novel",
                status = "Finished Airing",
                studios = emptyList(),
                synopsis = "Synopsis 2",
                themes = emptyList(),
                title = "Anime 2",
                titleEnglish = "Anime 2 English",
                title_japanese = "アニメ 2",
                title_synonyms = listOf("Synonym 2"),
                titles = emptyList(),
                type = "TV",
                url = "http://example.com/anime2",
                year = 2021
            )
        )
        val mockResponse = JikanResponse(data = mockAnimeResponseList)

        whenever(jikanService.getTrendingAnime()).thenReturn(mockResponse)

        // Act
        val result = dataSource.fetchData()

        // Assert
        val expected = mockAnimeResponseList.map { it.toAnimeHome() }
        assertEquals(expected, result)
    }

    @Test
    fun fetchDataPlusTest() = runTest {
        // Arrange
        val mockAnimeResponseList = listOf(
            AnimeResponse(
                airing = false,
                approved = true,
                background = "Background 1",
                demographics = emptyList(),
                duration = "24 min",
                episodes = 12,
                explicit_genres = emptyList(),
                favorites = 100,
                genres = emptyList(),
                images = Images(
                    jpg = Jpg(
                        image_url = "http://example.com/image1.jpg",
                        large_image_url = "http://example.com/large_image1.jpg",
                        small_image_url = "http://example.com/small_image1.jpg"
                    ),
                    webp = Webp(
                        image_url = "http://example.com/image1.webp",
                        large_image_url = "http://example.com/large_image1.webp",
                        small_image_url = "http://example.com/small_image1.webp"
                    )
                ),
                licensors = emptyList(),
                malId = 1,
                members = 1000,
                popularity = 500,
                producers = emptyList(),
                rank = 1,
                rating = "PG-13",
                score = 8.5,
                scored_by = 200,
                season = "Fall",
                source = "Manga",
                status = "Finished Airing",
                studios = emptyList(),
                synopsis = "Synopsis 1",
                themes = emptyList(),
                title = "Anime 1",
                titleEnglish = "Anime 1 English",
                title_japanese = "アニメ 1",
                title_synonyms = listOf("Synonym 1"),
                titles = emptyList(),
                type = "TV",
                url = "http://example.com/anime1",
                year = 2020
            ),
            AnimeResponse(
                airing = false,
                approved = true,
                background = "Background 2",
                demographics = emptyList(),
                duration = "24 min",
                episodes = 24,
                explicit_genres = emptyList(),
                favorites = 200,
                genres = emptyList(),
                images = Images(
                    jpg = Jpg(
                        image_url = "http://example.com/image2.jpg",
                        large_image_url = "http://example.com/large_image2.jpg",
                        small_image_url = "http://example.com/small_image2.jpg"
                    ),
                    webp = Webp(
                        image_url = "http://example.com/image2.webp",
                        large_image_url = "http://example.com/large_image2.webp",
                        small_image_url = "http://example.com/small_image2.webp"
                    )
                ),
                licensors = emptyList(),
                malId = 2,
                members = 2000,
                popularity = 400,
                producers = emptyList(),
                rank = 2,
                rating = "PG-13",
                score = 9.0,
                scored_by = 300,
                season = "Spring",
                source = "Light Novel",
                status = "Finished Airing",
                studios = emptyList(),
                synopsis = "Synopsis 2",
                themes = emptyList(),
                title = "Anime 2",
                titleEnglish = "Anime 2 English",
                title_japanese = "アニメ 2",
                title_synonyms = listOf("Synonym 2"),
                titles = emptyList(),
                type = "TV",
                url = "http://example.com/anime2",
                year = 2021
            )
        )
        val mockResponse = JikanResponse(data = mockAnimeResponseList)

        whenever(jikanService.getTrendingAnime()).thenReturn(mockResponse)

        // Act
        val result = dataSource.fetchDataPlus()

        // Assert
        val expected = mockAnimeResponseList.map { it.toAnime() }
        assertEquals(expected, result)
    }
}
