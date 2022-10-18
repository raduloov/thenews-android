package com.example.thenews.network.model

import com.example.thenews.domain.model.Article
import com.example.thenews.domain.util.DomainMapper

class ArticleDtoMapper : DomainMapper<ArticleDto, Article> {

    // Get
    override fun mapToDomainModel(model: ArticleDto): Article {
        return Article(
            id = model.id,
            title = model.title,
            author = model.author,
            publishedDate = model.publishedDate,
            publishedDatePrecision = model.publishedDatePrecision,
            link = model.link,
            cleanUrl = model.cleanUrl,
            excerpt = model.excerpt,
            summary = model.summary,
            rights = model.rights,
            rank = model.rank,
            topic = model.topic,
            country = model.country,
            language = model.language,
            authors = model.authors,
            media = model.media,
            isOpinion = model.isOpinion,
            twitterAccount = model.twitterAccount,
            _score = model._score
        )
    }

    // Post
    override fun mapFromDomainModel(domainModel: Article): ArticleDto {
        return ArticleDto(
            id = domainModel.id,
            title = domainModel.title,
            author = domainModel.author,
            publishedDate = domainModel.publishedDate,
            publishedDatePrecision = domainModel.publishedDatePrecision,
            link = domainModel.link,
            cleanUrl = domainModel.cleanUrl,
            excerpt = domainModel.excerpt,
            summary = domainModel.summary,
            rights = domainModel.rights,
            rank = domainModel.rank,
            topic = domainModel.topic,
            country = domainModel.country,
            language = domainModel.language,
            authors = domainModel.authors,
            media = domainModel.media,
            isOpinion = domainModel.isOpinion,
            twitterAccount = domainModel.twitterAccount,
            _score = domainModel._score
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