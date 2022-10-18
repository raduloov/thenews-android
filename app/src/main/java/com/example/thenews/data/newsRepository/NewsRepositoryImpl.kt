package com.example.thenews.data.newsRepository

import com.example.thenews.domain.model.Article
import com.example.thenews.network.NewsService
import com.example.thenews.network.model.ArticleDtoMapper

class NewsRepositoryImpl(
    private val newsService: NewsService,
    private val mapper: ArticleDtoMapper
) : NewsRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Article> {
        return mapper.toDomainList(newsService.search(token, page, query).articles)
    }

    override suspend fun getLatestHeadlines(token: String, page: Int, query: String): List<Article> {
        return mapper.toDomainList(newsService.getLatestHeadlines(token, page, query).articles)
    }
}