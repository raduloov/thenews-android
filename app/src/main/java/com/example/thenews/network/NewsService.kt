package com.example.thenews.network

import com.example.thenews.network.model.ArticleDto
import com.example.thenews.network.response.ArticleSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsService {

    @GET("get_latest_headlines")
    suspend fun getLatestHeadlines(
        @Header("x-api-key") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): ArticleSearchResponse

    @GET("search")
    suspend fun search(
        @Header("x-api-key") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): ArticleSearchResponse
}