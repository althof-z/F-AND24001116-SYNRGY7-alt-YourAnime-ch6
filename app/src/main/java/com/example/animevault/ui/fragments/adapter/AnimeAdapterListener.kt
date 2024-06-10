package com.example.animevault.ui.fragments.adapter

import com.example.domain.model.Anime

interface AnimeAdapterListener {
    fun onClickFavButton(data: Anime)
}