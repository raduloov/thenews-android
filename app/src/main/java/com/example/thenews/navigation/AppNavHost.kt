package com.example.thenews.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thenews.home.HomeScreen
import com.example.thenews.ui.auth.AuthViewModel
import com.example.thenews.ui.auth.LoginScreen
import com.example.thenews.ui.auth.SignUpScreen

@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_LOGIN,
    darkTheme: Boolean
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            LoginScreen(viewModel, navController, darkTheme)
        }
        composable(ROUTE_SIGNUP) {
            SignUpScreen(viewModel, navController, darkTheme)
        }
        composable(ROUTE_HOME) {
            HomeScreen(viewModel, navController)
        }
    }
}