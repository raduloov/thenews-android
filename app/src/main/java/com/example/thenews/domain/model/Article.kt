package com.example.thenews.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val id: String? = null,
    val title: String? = null,
    val author: String? = null,
    val publishedDate: String? = null,
    val publishedDatePrecision: String? = null,
    val link: String? = null,
    val cleanUrl: String? = null,
    val excerpt: String? = null,
    val summary: String? = null,
    val rights: String? = null,
    val rank: Int? = null,
    val topic: String? = null,
    val country: String? = null,
    val language: String? = null,
    val authors: String? = null,
    val media: String? = null,
    val isOpinion: Boolean? = null,
    val twitterAccount: String? = null,
    val _score: Int? = null,
) : Parcelable