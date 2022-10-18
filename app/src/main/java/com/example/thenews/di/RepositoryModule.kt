package com.example.thenews.di

import com.example.thenews.data.newsRepository.NewsRepository
import com.example.thenews.data.newsRepository.NewsRepositoryImpl
import com.example.thenews.network.NewsService
import com.example.thenews.network.model.ArticleDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideArticleRepository(
        newsService: NewsService,
        articleDtoMapper: ArticleDtoMapper
    ): NewsRepository {
        return NewsRepositoryImpl(newsService, articleDtoMapper)
    }
}