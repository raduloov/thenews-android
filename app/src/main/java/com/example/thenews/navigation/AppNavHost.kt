package com.example.thenews.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thenews.home.HomeScreen
import com.example.thenews.presentation.auth.AuthViewModel
import com.example.thenews.presentation.auth.LoginScreen
import com.example.thenews.presentation.auth.SignUpScreen
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory

@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_LOGIN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            val authViewModel = hiltViewModel<AuthViewModel>()
            LoginScreen(authViewModel, navController)
        }
        composable(ROUTE_SIGNUP) {
            SignUpScreen(viewModel, navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(viewModel, navController)
        }
    }
}