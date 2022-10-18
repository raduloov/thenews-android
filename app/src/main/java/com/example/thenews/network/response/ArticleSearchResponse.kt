package com.example.thenews.network.response

import com.example.thenews.network.model.ArticleDto
import com.example.thenews.network.model.UserInputDto
import com.google.gson.annotations.SerializedName

data class ArticleSearchResponse(

    @SerializedName("ok")
    var ok: String,

    @SerializedName("total_hits")
    var totalHits: Int,

    @SerializedName("page")
    var page: Int,

    @SerializedName("total_pages")
    var totalPages: Int,

    @SerializedName("articles")
    var articles: List<ArticleDto>,

    @SerializedName("user_input")
    var userInput: UserInputDto
)