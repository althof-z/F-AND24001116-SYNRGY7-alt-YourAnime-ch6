package com.example.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.room.Room
import com.example.data.datasource.AnimeLocalData
import com.example.data.datasource.AnimeRemoteData
import com.example.data.datasource.AuthLocalData
import com.example.data.datasource.AuthRemoteData
import com.example.data.datasource.local.AnimeLocalDataImpl
import com.example.data.datasource.local.AuthLocalDataImpl
import com.example.data.datasource.local.dataStore
import com.example.data.datasource.local.room.AnimeDao
import com.example.data.datasource.local.room.AppDatabase
import com.example.data.datasource.remote.AnimeRemoteDataImpl
import com.example.data.datasource.remote.AuthRemoteDataImpl
import com.example.data.datasource.remote.retrofit.JikanService
import com.example.data.datasource.remote.retrofit.provideJikanService
import com.example.data.repository.AnimeRepositoryImpl
import com.example.data.repository.AuthRepositoryImpl
import com.example.domain.repository.AnimeRepository
import com.example.domain.repository.AuthRepository
import com.example.domain.usecases.LoginUsesCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val koinModule = module {
    single<LoginUsesCase> { LoginUsesCase(repository = get()) }
    single<AuthRepository> { AuthRepositoryImpl(authLocalData = get(), authRemoteData = get()) }
    single<AnimeRepository> { AnimeRepositoryImpl(remoteData = get(), localData = get()) }
    single<AnimeLocalData> { AnimeLocalDataImpl(animeDao = get())}
    single<AppDatabase> { Room.databaseBuilder(context = get(), name = AppDatabase.DATABASE_NAME, klass = AppDatabase::class.java).build() }
    single<AnimeDao> { (get() as AppDatabase).animeDao() }
    single <AnimeRemoteData> { AnimeRemoteDataImpl(jikanService = get()) }
    single<JikanService>  { provideJikanService(get()) }
    single<AuthLocalData> { AuthLocalDataImpl(dataStore = get()) }
    single<DataStore<Preferences>> { androidContext().dataStore }
    single<AuthRemoteData> { AuthRemoteDataImpl() }

}