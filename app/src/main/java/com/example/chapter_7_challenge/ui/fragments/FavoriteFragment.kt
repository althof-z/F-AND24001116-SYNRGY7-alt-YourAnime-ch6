package com.example.chapter_7_challenge.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_7_challenge.R
import com.example.chapter_7_challenge.databinding.FragmentFavoriteBinding
import com.example.chapter_7_challenge.ui.fragments.adapter.AnimeAdapter
import com.example.chapter_7_challenge.ui.fragments.adapter.AnimeAdapterListener
import com.example.domain.model.Anime
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoriteFragment : Fragment(), AnimeAdapterListener {

    private lateinit var binding: FragmentFavoriteBinding
    private val animeAdapter = AnimeAdapter(this)

    private val viewModel by viewModel<FavoriteFragmentViewModel> ()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_logout -> {
                        viewModel.logout()
                        activity?.finish()
                        true
                    }
                    R.id.action_favorite ->{
                        findNavController().navigateUp()
                        true
                    }
                    R.id.action_account ->{
                        findNavController().navigate(R.id.action_favoriteFragment_to_profileFragment)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        viewModel.error.observe(viewLifecycleOwner){error ->
            Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
        }

        setupAnimeRV()

    }

    private fun setupAnimeRV(){
        binding.rvAnimeList.apply {
            adapter = animeAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }

        viewModel.getMovieFromLocal()

        viewModel.animes.observe(viewLifecycleOwner){ animes ->
            animeAdapter.submitList(animes)
        }
    }

    override fun onClickFavButton(data: Anime) {
        viewModel.loadAnimeFromFavorite(data.id)
        viewModel.deleteAnimeFromFavorite(data)
        viewModel.getMovieFromLocal()
    }

    override fun onClickSearchButton(data: Anime) {
        searchAnime(data)
    }

    private fun searchAnime(data: Anime) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setData(Uri.parse("https://www.google.com/search?q=${data.title}"))
        }
        startActivity(intent)
    }


}