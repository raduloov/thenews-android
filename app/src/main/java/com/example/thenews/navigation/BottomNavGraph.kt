package com.example.thenews.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.thenews.ui.screens.feed.FeedScreen
import com.example.thenews.ui.screens.profile.ProfileScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreens.Feed.route
    ) {
        composable(route = BottomBarScreens.Feed.route) {
            FeedScreen(navController)
        }
        composable(route = BottomBarScreens.Discover.route) {
            FeedScreen(navController)
        }
        composable(route = BottomBarScreens.Profile.route) {
            ProfileScreen(navController)
        }
    }
}

sealed class BottomBarScreens(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    object Feed: BottomBarScreens(
        route = "feed",
        title = "Feed",
        selectedIcon = Icons.Filled.Feed,
        unselectedIcon = Icons.Outlined.Feed
    )

    object Discover: BottomBarScreens(
        route = "discover",
        title = "Discover",
        selectedIcon = Icons.Filled.Explore,
        unselectedIcon = Icons.Outlined.Explore
    )

    object Profile: BottomBarScreens(
        route = "profile",
        title = "Profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person
    )
}