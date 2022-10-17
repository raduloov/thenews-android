package com.example.thenews.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.thenews.ui.MainScreen
import com.example.thenews.ui.auth.AuthViewModel

fun NavGraphBuilder.loggedInNavGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    navigation(
        route = Graph.LOGGED_IN,
        startDestination = LoggedInScreen.BottomTab.route
    ) {
        composable(route = LoggedInScreen.BottomTab.route) {
            MainScreen(authViewModel)
        }
//        composable(route = LoggedInScreen.Home.route) {
//            HomeScreen(
//                viewModel = authViewModel,
//                navController = navController
//            )
//        }
//        composable(route = LoggedInScreen.Profile.route) {
//            HomeScreen(
//                viewModel = authViewModel,
//                navController = navController
//            )
//        }
//        composable(route = LoggedInScreen.Settings.route) {
//            HomeScreen(
//                viewModel = authViewModel,
//                navController = navController
//            )
//        }
    }
}

sealed class LoggedInScreen(val route: String) {
    object BottomTab : AuthScreen(route = "BOTTOM_TAB")
}