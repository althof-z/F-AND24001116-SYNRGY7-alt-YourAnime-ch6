package com.example.chapter_6_challenge.ui.fragments.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val id: Int,
    val image: String,
    val title: String,
    val desc: String,
): Parcelable
