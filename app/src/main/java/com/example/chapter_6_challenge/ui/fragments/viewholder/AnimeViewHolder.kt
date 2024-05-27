package com.example.chapter_6_challenge.ui.fragments.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.chapter_6_challenge.databinding.ItemAnimeNewBinding
import com.example.chapter_6_challenge.ui.fragments.adapter.AnimeAdapterListener
import com.example.domain.model.Anime

class AnimeViewHolder (
    private val itemViewBinding: ItemAnimeNewBinding, private val animeAdapterListener: AnimeAdapterListener

): RecyclerView.ViewHolder(itemViewBinding.root) {

    fun bindAnime(data: Anime){
        itemViewBinding.tvAnimeTitle.text = data.title

        itemViewBinding.ivAnimeCover.load(data.image)

        itemViewBinding.tvAnimeDesc.text = data.desc

        itemViewBinding.btnSearchAnime.setOnClickListener{
            animeAdapterListener.onClickSearchButton(data)
        }

        itemViewBinding.btnFavAnime.setOnClickListener{
            animeAdapterListener.onClickFavButton(data)
        }
    }


}