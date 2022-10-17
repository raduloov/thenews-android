package com.example.thenews.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thenews.ui.theme.Clouds
import com.example.thenews.ui.theme.Grey500
import com.example.thenews.ui.theme.Grey900

@Composable
fun LogoGradient(
    isDark: Boolean
) {

    val brush = Brush.horizontalGradient(
        if (isDark) {
             listOf(Color(0xFFDADDF7), Color(0xFF9AA2FF))
        } else {
             listOf(Color(0xFF9AA2FF), Color(0xFF5900FF))
        }
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp, bottom = 50.dp)
    ) {
        Row {
            Text(
                text = "The",
                style = TextStyle(
                    fontSize = 50.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Grey500
                )
            )
            Text(
                text = "NEWS",
                style = TextStyle(
                    fontSize = 50.sp,
                    fontWeight = FontWeight.ExtraBold
                ),
                modifier = Modifier
                    .graphicsLayer(alpha = 0.99f)
                    .drawWithCache {
                        onDrawWithContent {
                            drawContent()
                            drawRect(brush = brush, blendMode = BlendMode.SrcAtop)
                        }
                    }
            )
        }

        Text(
            text = "Your place for the latest world news!",
            style = TextStyle(
                fontSize = 20.sp,
                color = if (isDark) Clouds else Grey500
            )
        )
    }
}