package com.example.thenews.navigation

import com.example.thenews.home.HomeScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.thenews.ui.auth.AuthViewModel

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    navigation(
        route = Graph.LOGGED_IN,
        startDestination = LoggedInScreen.Home.route
    ) {
        composable(route = LoggedInScreen.Home.route) {
            HomeScreen(
                viewModel = authViewModel,
                navController = navController
            )
        }
        composable(route = LoggedInScreen.Profile.route) {
            HomeScreen(
                viewModel = authViewModel,
                navController = navController
            )
        }
        composable(route = LoggedInScreen.Settings.route) {
            HomeScreen(
                viewModel = authViewModel,
                navController = navController
            )
        }
    }
}

sealed class LoggedInScreen(val route: String) {
    object Home : AuthScreen(route = "HOME")
    object Profile : AuthScreen(route = "PROFILE")
    object Settings : AuthScreen(route = "SETTINGS")
}