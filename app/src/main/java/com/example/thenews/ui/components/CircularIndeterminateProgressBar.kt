package com.example.thenews.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.thenews.ui.theme.White

@Composable
fun CircularIndeterminateProgressBar(
    isDisplayed: Boolean,
    verticalBias: Float
) {
    if (isDisplayed) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x68000000))
        ) {
            val (progressBar) = createRefs()
            val topBias = createGuidelineFromTop(verticalBias)

            CircularProgressIndicator(
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .constrainAs(progressBar) {
                        top.linkTo(topBias)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    },
                color = White
            )
        }
    }
}