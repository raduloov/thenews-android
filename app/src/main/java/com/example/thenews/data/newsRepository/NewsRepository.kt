package com.example.thenews.data.newsRepository

import com.example.thenews.domain.model.Article

interface NewsRepository {

    suspend fun search(token: String, page: Int, query: String): List<Article>

    suspend fun getLatestHeadlines(token: String, page: Int, query: String): List<Article>
}