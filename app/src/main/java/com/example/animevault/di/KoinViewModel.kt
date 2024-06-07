package com.example.animevault.di

import com.example.animevault.ui.MainActViewModel
import com.example.animevault.ui.fragments.AnimeFragmentViewModel
import com.example.animevault.ui.fragments.FavoriteFragmentViewModel
import com.example.animevault.ui.fragments.FirstFragViewModel
import com.example.animevault.ui.fragments.LoginViewModel
import com.example.animevault.ui.fragments.ProfileFragmentViewModel
import com.example.animevault.ui.fragments.HomeFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ LoginViewModel(loginUsesCase = get())}
    viewModel{ MainActViewModel(authRepository = get()) }
    viewModel{ FirstFragViewModel(authRepository = get())}
    viewModel { AnimeFragmentViewModel(authRepository = get(), animeRepository = get()) }
    viewModel { HomeFragmentViewModel(authRepository = get(), animeRepository = get()) }
    viewModel{ FavoriteFragmentViewModel(authRepository = get(), animeRepository = get())}
    viewModel { ProfileFragmentViewModel(get())}

}