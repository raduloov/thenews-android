package com.example.thenews.network.model

import com.google.gson.annotations.SerializedName

data class ArticleDto(

    @SerializedName("source")
    var source: SourceDto? = null,

    @SerializedName("author")
    var author: String? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("urlToImage")
    var urlToImage: String? = null,

    @SerializedName("publishedAt")
    var publishedAt: String? = null,

    @SerializedName("content")
    var content: String? = null
)

data class SourceDto(

    @SerializedName("id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null
)