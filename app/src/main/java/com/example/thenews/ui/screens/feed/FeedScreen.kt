package com.example.thenews.ui.screens.feed

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.thenews.ui.components.ArticleList
import com.example.thenews.ui.components.CircularIndeterminateProgressBar
import com.example.thenews.ui.components.utils.SnackbarController
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope

const val PAGE_SIZE = 50

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun FeedScreen(
    navController: NavHostController
) {

    val viewModel: FeedViewModel = hiltViewModel()

    val articles = viewModel.articles.value
    val loading = viewModel.loading.value
    val page = viewModel.page.value
    val scaffoldState = rememberScaffoldState()
    val snackbarController = SnackbarController(GlobalScope)

    Scaffold(
        topBar = { Text(text = "The NEWS Home Screen") },
        scaffoldState = scaffoldState,
        snackbarHost = { scaffoldState.snackbarHostState }
    ) { padding ->
        if (loading) {
            CircularIndeterminateProgressBar(verticalBias = 0.4f)
        } else {
            Box {
                ArticleList(
                    loading = loading,
                    padding = padding,
                    articles = articles,
                    onChangeRecipeScrollPosition = viewModel::onChangeArticleScrollPosition,
                    page = page,
                    onNextPage = { viewModel.onTriggerEvent(ArticleListEvent.NextPageEvent) },
                    scaffoldState = scaffoldState,
                    snackbarController = snackbarController,
                    navController = navController
                )
            }
        }
    }
}

