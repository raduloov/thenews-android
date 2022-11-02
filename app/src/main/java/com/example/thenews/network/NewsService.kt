package com.example.thenews.network

import com.example.thenews.network.response.ArticleSearchResponse
import com.example.thenews.utils.TOP_HEADLINES
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsService {

    @GET(TOP_HEADLINES)
    suspend fun getTopHeadlines(
        @Header("x-api-key") token: String,
        @Query("country") country: String,
//        @Query("topic") topic: String,
        @Query("page") page: Int
    ): ArticleSearchResponse

    @GET("search")
    suspend fun search(
        @Header("x-api-key") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): ArticleSearchResponse
}