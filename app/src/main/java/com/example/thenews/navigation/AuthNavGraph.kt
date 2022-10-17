package com.example.thenews.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.thenews.ui.auth.AuthViewModel
import com.example.thenews.ui.auth.LoginScreen
import com.example.thenews.ui.auth.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(
                viewModel = authViewModel,
                navController = navController,
                isDark = false
            )
        }
        composable(route = AuthScreen.SignUp.route) {
            SignUpScreen(
                viewModel = authViewModel,
                navController = navController,
                isDark = false
            )
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
}