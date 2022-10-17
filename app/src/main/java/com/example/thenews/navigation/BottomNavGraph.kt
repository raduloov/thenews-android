package com.example.thenews.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.thenews.home.HomeScreen
import com.example.thenews.ui.auth.AuthViewModel

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreens.Home.route
    ) {
        composable(route = BottomBarScreens.Home.route) {
            HomeScreen(authViewModel, navController)
        }
        composable(route = BottomBarScreens.Profile.route) {
            HomeScreen(authViewModel, navController)
        }
        composable(route = BottomBarScreens.Settings.route) {
            HomeScreen(authViewModel, navController)
        }
    }
}