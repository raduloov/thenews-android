package com.example.thenews.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.thenews.ui.auth.AuthViewModel

@Composable
fun HomeScreen(
    viewModel: AuthViewModel?,
    navController: NavHostController
) {
    Text(text = "The NEWS Home Screen")
}

