package com.example.animevault.ui.fragments.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.animevault.databinding.ItemAnimeHomeBinding
import com.example.animevault.ui.fragments.adapter.AnimeAdapterListener
import com.example.domain.model.Anime

class AnimeHomeViewHolder(
    private val itemViewBinding: ItemAnimeHomeBinding, private val animeAdapterListener: AnimeAdapterListener

): RecyclerView.ViewHolder(itemViewBinding.root) {

    fun bindAnime(data: Anime){
        itemViewBinding.tvAnimeTitle.text = data.title

        itemViewBinding.ivAnimeCoverHome.load(data.image)

        itemViewBinding.tvAnimeDesc.text = data.desc

    }


}