package com.example.animevault.ui.fragments.adapter

import com.example.domain.model.Anime
import com.example.domain.model.AnimeHome

interface AnimeAdapterListener {
    fun onClickFavButton(data: Anime)
}