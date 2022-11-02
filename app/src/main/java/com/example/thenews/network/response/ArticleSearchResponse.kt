package com.example.thenews.network.response

import com.example.thenews.network.model.ArticleDto
import com.google.gson.annotations.SerializedName

data class ArticleSearchResponse(

    @SerializedName("status")
    var status: String,

    @SerializedName("totalResults")
    var totalResults: Int,

    @SerializedName("articles")
    var articles: List<ArticleDto>
)