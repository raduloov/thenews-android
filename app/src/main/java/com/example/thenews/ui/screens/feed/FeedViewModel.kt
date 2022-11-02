package com.example.thenews.ui.screens.feed

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thenews.data.newsRepository.NewsRepository
import com.example.thenews.domain.model.Article
import com.example.thenews.utils.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val repository: NewsRepository,
    @Named("auth_token") private val token: String
) : ViewModel() {

    val articles: MutableState<List<Article>> = mutableStateOf(ArrayList())
    val loading = mutableStateOf(false)
    val query = mutableStateOf("")
    val page = mutableStateOf(1)
    private var recipeListScrollPosition = 0

    init {
        onTriggerEvent(ArticleListEvent.NewSearchEvent)
//        if (recipeListScrollPosition != 0) {
//            onTriggerEvent(ArticleListEvent.RestoreStateEvent)
//        } else {
//            onTriggerEvent(ArticleListEvent.NewSearchEvent)
//        }
    }

    fun onTriggerEvent(event: ArticleListEvent) {
        viewModelScope.launch {
            try {
                when (event) {
                    is ArticleListEvent.NewSearchEvent -> {
                        newSearch()
                    }
                    is ArticleListEvent.NextPageEvent -> {
                        nextPage()
                    }
                    is ArticleListEvent.RestoreStateEvent -> {
//                        restoreState()
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "onTriggerEvent: Exception $e, ${e.cause}" )
            }
        }
    }

    private suspend fun newSearch() {
        loading.value = true
        delay(2000)
//        resetSearchState()

        val result = repository.getTopHeadlines(
            token = token,
            country = "us",
            page = 1,
//            topic = "all"
        )
        Log.d(TAG, "result: $result")
        articles.value = result

        loading.value = false
    }

    private suspend fun nextPage() {
        // prevent duplicate events due to recompose happening too quickly
        if ((recipeListScrollPosition + 1) >= (page.value * PAGE_SIZE)) {
            loading.value = true
            incrementPage()
            Log.d(TAG, "nextPage: triggered: ${page.value}")

            // just to show pagination
            delay(1000)

            if (page.value > 1) {
                val result = repository.search(
                    token = token,
                    page = page.value,
                    query = query.value
                )
                Log.d(TAG, "nextPage: $result")
                appendRecipes(result)
            }
            loading.value = false
        }
    }

    /**
     * Called when a new search is executed.
     */
    private fun resetSearchState() {
        articles.value = listOf()
        page.value = 1
        onChangeArticleScrollPosition(0)
//        if (selectedCategory.value?.value != query.value) clearSelectedCategory()
    }

    fun onChangeArticleScrollPosition(position: Int){
        setListScrollPosition(position)
    }

    fun onQueryChanged(query: String) {
        setQuery(query)
    }

    private fun appendRecipes(recipes: List<Article>){
        val current = ArrayList(this.articles.value)
        current.addAll(recipes)
        this.articles.value = current
    }

    private fun incrementPage(){
        setPage(page.value + 1)
    }

    private fun setListScrollPosition(position: Int) {
        recipeListScrollPosition = position
//        savedStateHandle.set(STATE_KEY_LIST_POSITION, position)
    }

    private fun setPage(page: Int) {
        this.page.value = page
//        savedStateHandle.set(STATE_KEY_PAGE, page)
    }

    private fun setQuery(query: String) {
        this.query.value = query
//        savedStateHandle.set(STATE_KEY_QUERY, query)
    }
}