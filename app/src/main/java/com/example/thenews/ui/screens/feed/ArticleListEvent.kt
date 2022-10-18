package com.example.thenews.ui.screens.feed

sealed class ArticleListEvent {

    object NewSearchEvent: ArticleListEvent()

    object NextPageEvent: ArticleListEvent()

    // restore after process death
    object RestoreStateEvent: ArticleListEvent()
}