package com.example.chapter_7_challenge.di

import com.example.chapter_7_challenge.ui.MainActViewModel
import com.example.chapter_7_challenge.ui.fragments.AnimeFragmentViewModel
import com.example.chapter_7_challenge.ui.fragments.FavoriteFragmentViewModel
import com.example.chapter_7_challenge.ui.fragments.FirstFragViewModel
import com.example.chapter_7_challenge.ui.fragments.LoginViewModel
import com.example.chapter_7_challenge.ui.fragments.ProfileFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ LoginViewModel(loginUsesCase = get())}
    viewModel{ MainActViewModel(authRepository = get()) }
    viewModel{ FirstFragViewModel(authRepository = get())}
    viewModel { AnimeFragmentViewModel(authRepository = get(), animeRepository = get()) }
    viewModel{ FavoriteFragmentViewModel(authRepository = get(), animeRepository = get())}
    viewModel { ProfileFragmentViewModel(get())}

}