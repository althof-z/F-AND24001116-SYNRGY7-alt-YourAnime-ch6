package com.example.chapter_6_challenge.ui.fragments.adapter

import com.example.chapter_6_challenge.ui.fragments.data.Anime

interface AnimeAdapterListener {

    fun onClickFavButton(data: Anime)
    fun onClickSearchButton(data: Anime)
}