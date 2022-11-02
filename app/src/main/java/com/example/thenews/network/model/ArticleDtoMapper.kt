package com.example.thenews.network.model

import com.example.thenews.domain.model.Article
import com.example.thenews.domain.model.Source
import com.example.thenews.domain.util.DomainMapper

class ArticleDtoMapper : DomainMapper<ArticleDto, Article> {

    // Get
    override fun mapToDomainModel(model: ArticleDto): Article {
        return Article(
            source = Source(
                id = model.source?.id,
                name = model.source?.name
            ),
            author = model.author,
            title = model.title,
            description = model.description,
            url = model.url,
            urlToImage = model.urlToImage,
            publishedAt = model.publishedAt,
            content = model.content
        )
    }

    // Post
    override fun mapFromDomainModel(domainModel: Article): ArticleDto {
        return ArticleDto(
            source = SourceDto(
                id = domainModel.source?.id,
                name = domainModel.source?.name
            ),
            author = domainModel.author,
            title = domainModel.title,
            description = domainModel.description,
            url = domainModel.url,
            urlToImage = domainModel.urlToImage,
            publishedAt = domainModel.publishedAt,
            content = domainModel.content
        )
    }

    fun toDomainList(initial: List<ArticleDto>): List<Article> {
        return initial.map {
            mapToDomainModel(it)
        }
    }

    fun fromDomainList(initial: List<Article>): List<ArticleDto> {
        return initial.map {
            mapFromDomainModel(it)
        }
    }
}