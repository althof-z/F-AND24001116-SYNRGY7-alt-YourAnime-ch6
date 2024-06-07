package com.example.animevault.ui.fragments.adapter

import com.example.domain.model.AnimeHome

interface AnimeAdapterListener {

    fun onClickFavButton(data: AnimeHome)
    fun onClickSearchButton(data: AnimeHome)
}