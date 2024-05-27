package com.example.chapter_6_challenge.ui.fragments

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import androidx.savedstate.SavedStateRegistryOwner
import com.example.data.datasource.AnimeLocalData
import com.example.data.datasource.local.AnimeLocalDataImpl
import com.example.data.datasource.local.AuthLocalDataImpl
import com.example.data.datasource.local.dataStore
import com.example.data.datasource.local.room.AppDatabase
import com.example.data.datasource.remote.AnimeRemoteDataImpl
import com.example.data.datasource.remote.AuthRemoteDataImpl
import com.example.data.datasource.remote.retrofit.provideJikanService
import com.example.data.repository.AnimeRepositoryImpl
import com.example.data.repository.AuthRepositoryImpl
import com.example.domain.model.Anime
import com.example.domain.repository.AnimeRepository
import com.example.domain.repository.AuthRepository
import kotlinx.coroutines.launch

class AnimeFragmentViewModel(
    private val animeRepository: AnimeRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    companion object {
        fun provideFactory(
            owner: SavedStateRegistryOwner,
            context: Context,
        ): AbstractSavedStateViewModelFactory =
            object : AbstractSavedStateViewModelFactory(owner, null) {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle,
                ): T {
                    val appDatabase = Room.databaseBuilder(
                        context = context,
                        name = AppDatabase.DATABASE_NAME,
                        klass = AppDatabase :: class.java,
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    val localData: AnimeLocalData =
                        AnimeLocalDataImpl(
                            animeDao = appDatabase.animeDao(),
                        )
                    val remoteData: com.example.data.datasource.AnimeRemoteData = AnimeRemoteDataImpl(
                        jikanService = provideJikanService(context)
                    )
                    val myRepository: AnimeRepository =
                        AnimeRepositoryImpl(
                            remoteData = remoteData,
                            localData = localData,
                        )
                    val authRepository: AuthRepository =
                        AuthRepositoryImpl(
                            authLocalData = AuthLocalDataImpl(
                                dataStore = context.dataStore,
                            ),
                            authRemoteData = AuthRemoteDataImpl(),
                        )
                    return AnimeFragmentViewModel(
                        animeRepository = myRepository,
                        authRepository = authRepository
                    ) as T
                }
            }
    }

    private val _animes: MutableLiveData<List<Anime>> = MutableLiveData()
    val animes: LiveData<List<Anime>> = _animes

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = _error

    fun retrieveAvailableAnimes(){
        viewModelScope.launch {
            try{
                _loading.value = true
                _animes.value = animeRepository.fetchData()
                _loading.value = false
            }catch (throwable: Throwable){
                _loading.value = false
                _error.value = throwable
            }

        }

    }


    fun storeToFavorite(
        title: String,
        image: String,
        id: Int,
        desc: String
    ){
      viewModelScope.launch {
          val anime = Anime(
              id = id,
              image = image,
              desc = desc,
              title = title,
          )
          animeRepository.storeFavorite(anime)
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


    private val _animeLocal = MutableLiveData<Anime?>()
    fun loadAnimeFromFavorite(id: Int){
        viewModelScope.launch {
            try {
                _animeLocal.value = animeRepository.getMovieById(id)
            } catch (throwable: Throwable){
                _error.value = throwable
            }
        }
    }


}