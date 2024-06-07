package com.example.animevault.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.AnimeHome
import com.example.domain.repository.AnimeRepository
import com.example.domain.repository.AuthRepository
import kotlinx.coroutines.launch

class FavoriteFragmentViewModel(
    private val animeRepository: AnimeRepository,
    private val authRepository: AuthRepository,
): ViewModel(){

    private val _animes: MutableLiveData<List<AnimeHome>> = MutableLiveData()
    val animes: LiveData<List<AnimeHome>> = _animes

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = _error

    fun getMovieFromLocal(){
        viewModelScope.launch {
            try {
                _animes.value = animeRepository.getAllAnime()
            } catch (throwable: Throwable) {
                _error.value = throwable
            }
        }
    }

    fun deleteAnimeFromFavorite(animeHome: AnimeHome){
        viewModelScope.launch {
            animeRepository.deleteAnime(animeHome)
        }
    }

    private val _animeLocal = MutableLiveData<AnimeHome?>()
    fun loadAnimeFromFavorite(id: Int){
        viewModelScope.launch {
            try {
                _animeLocal.value = animeRepository.getMovieById(id)
            } catch (throwable: Throwable){
                _error.value = throwable
            }
        }
    }
    fun logout() {
        viewModelScope.launch {
            try {
                authRepository.clearToken()
            } catch (throwable: Throwable) {
                _error.value = throwable
            }
        }
    }


}