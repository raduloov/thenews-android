package com.example.thenews.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.thenews.home.HomeScreen
import com.example.thenews.ui.ProfileScreen
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
        composable(route = BottomBarScreens.Settings.route) {
            HomeScreen(authViewModel, navController)
        }
        composable(route = BottomBarScreens.Profile.route) {
            ProfileScreen(authViewModel, navController)
        }
    }
}

sealed class BottomBarScreens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: BottomBarScreens(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile: BottomBarScreens(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )

    object Settings: BottomBarScreens(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )
}