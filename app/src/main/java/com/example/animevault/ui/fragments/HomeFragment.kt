package com.example.animevault.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.animevault.databinding.FragmentHomeBinding
import com.example.animevault.ui.fragments.adapter.AnimeHomeAdapter
import com.example.animevault.ui.fragments.adapter.AnimeAdapterListener
import com.example.domain.model.AnimeHome
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), AnimeAdapterListener {
    private lateinit var binding: FragmentHomeBinding
    private val animeHomeAdapter = AnimeHomeAdapter(this)

    private val viewModel by viewModel<HomeFragmentViewModel> ()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.error.observe(viewLifecycleOwner){error ->
            Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
        }

        setupAnimeRV()

        viewModel.retrieveAvailableAnimes()

        viewModel.animes.observe(viewLifecycleOwner){ animes ->
            animeHomeAdapter.submitList(animes)
        }
        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.ivHighlightAnime.load("https://wallpapers.com/images/hd/fullmetal-alchemist-brotherhood-action-poster-0tvvnvos36llm4yx.webp")
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun setupAnimeRV(){
        binding.rvAnimeHome.apply {
            adapter = animeHomeAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            itemAnimator = DefaultItemAnimator()
        }
    }

    override fun onClickFavButton(data: AnimeHome) {
        TODO("Not yet implemented")
    }

    override fun onClickSearchButton(data: AnimeHome) {
        TODO("Not yet implemented")
    }

}