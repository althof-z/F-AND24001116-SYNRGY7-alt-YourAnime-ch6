package com.example.animevault.ui.fragments.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.animevault.databinding.ItemAnimeNewBinding
import com.example.animevault.ui.fragments.adapter.AnimeAdapterListener
import com.example.domain.model.Anime
import com.example.domain.model.AnimeHome

class AnimeViewHolder (
    private val itemViewBinding: ItemAnimeNewBinding, private val animeAdapterListener: AnimeAdapterListener

): RecyclerView.ViewHolder(itemViewBinding.root) {

    fun bindAnime(data: Anime){
        itemViewBinding.tvAnimeTitle.text = data.title

        itemViewBinding.ivAnimeCover.load(data.image)

        itemViewBinding.tvAnimeDesc.text = data.synopsis

        itemViewBinding.tvTagYear.text = data.year.toString()

        itemViewBinding.tvTagEpisode.text = data.episode

        itemViewBinding.tvRate.text = data.rate.toString()

//        itemViewBinding.btnFavAnime.setOnClickListener{
//            animeAdapterListener.onClickFavButton(data)
//        }
    }


}