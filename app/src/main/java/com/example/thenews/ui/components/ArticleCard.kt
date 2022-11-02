package com.example.thenews.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.thenews.domain.model.Article
import com.example.thenews.utils.DEFAULT_ARTICLE_PLACEHOLDER
import com.example.thenews.utils.loadPicture

@Composable
fun ArticleCard(
    article: Article,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Column {
            article.urlToImage?.let { url ->
                val image = loadPicture(url = url, defaultImage = DEFAULT_ARTICLE_PLACEHOLDER).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(225.dp),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Article image"
                    )
                }
            }
            article.title?.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                ){
                    Text(
                        text = title,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start)
                        ,
                        style = MaterialTheme.typography.h3
                    )
//                    val rank = article.rank.toString()
//                    Text(
//                        text = rank,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .wrapContentWidth(Alignment.End)
//                            .align(Alignment.CenterVertically)
//                        ,
//                        style = MaterialTheme.typography.h5
//                    )
                }
            }
        }
    }
}