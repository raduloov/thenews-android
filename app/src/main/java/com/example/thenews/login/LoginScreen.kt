package com.example.thenews.login

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.thenews.ui.theme.TheNewsTheme

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel? = null,
    onNavigateToHomeScreen: () -> Unit,
    onNavigateToSignUpScreen: () -> Unit
) {
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.loginError != null
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colors.primary
        )

        if (isError) {
            Text(
                text = loginUiState?.loginError ?: "An unknown error occurred.",
                color = Color.Red
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    TheNewsTheme {
        LoginScreen(onNavigateToHomeScreen = { /*TODO*/ }) {
            
        }
    }
}