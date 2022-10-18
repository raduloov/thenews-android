package com.example.thenews.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.thenews.domain.model.Article
import com.example.thenews.ui.components.utils.SnackbarController
import com.example.thenews.ui.screens.feed.ArticleListEvent
import com.example.thenews.ui.screens.feed.PAGE_SIZE
import kotlinx.coroutines.launch

@Composable
fun ArticleList(
    padding: PaddingValues,
    loading: Boolean,
    articles: List<Article>,
    onChangeRecipeScrollPosition: (Int) -> Unit,
    page: Int,
    onNextPage: (ArticleListEvent) -> Unit,
    scaffoldState: ScaffoldState,
    snackbarController: SnackbarController,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface)
            .padding(padding)
    ) {
        LazyColumn {
            itemsIndexed(
                items = articles
            ) { index, article ->
                onChangeRecipeScrollPosition(index)
                if ((index + 1) >= (page * PAGE_SIZE) && !loading) {
                    onNextPage(ArticleListEvent.NextPageEvent)
                }
                ArticleCard(
                    article = article,
                    onClick = {
//                        if (article.id != null) {
//                            val bundle = Bundle()
//                            bundle.putInt("recipeId", article.id)
//                            navController.navigate(R.id.viewRecipe, bundle)
//                        } else {
                            snackbarController.getScope().launch {
                                snackbarController.showSnackbar(
                                    scaffoldState = scaffoldState,
                                    message = "Recipe Error",
                                    actionLabel = "OK"
                                )
//                            }
                        }
                    }
                )
            }
        }
    }
}