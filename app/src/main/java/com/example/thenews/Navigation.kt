package com.example.thenews

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thenews.home.HomeScreen
import com.example.thenews.ui.components.auth.SignInScreen
import com.example.thenews.ui.components.auth.AuthViewModel
import com.example.thenews.ui.components.auth.SignUpScreen

enum class AuthRoute {
    SignUp,
    SignIn
}

enum class HomeRoute {
    Home,
    Details
}

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    loginViewModel: AuthViewModel
) {
    NavHost(
        navController = navController,
        startDestination = AuthRoute.SignIn.name
    ) {
        composable(route = AuthRoute.SignIn.name) {
            SignInScreen(onNavigateToHomeScreen = {
                navController.navigate(AuthRoute.SignIn.name) {
                    launchSingleTop = true
                    popUpTo(route = AuthRoute.SignIn.name) {
                        inclusive = true
                    }
                }
            },
                viewModel = loginViewModel

            ) {
                navController.navigate(AuthRoute.SignUp.name) {
                    launchSingleTop = true
                    popUpTo(AuthRoute.SignIn.name) {
                        inclusive = true
                    }
                }
            }
        }

        composable(route = AuthRoute.SignUp.name) {
            SignUpScreen(onNavigateToHomeScreen = {
                navController.navigate(HomeRoute.Home.name) {
                    popUpTo(HomeRoute.Home.name) {
                        inclusive = true
                    }
                }
            },
                loginViewModel = loginViewModel
            ) {
                navController.navigate(AuthRoute.SignIn.name)
            }

        }


        composable(route = HomeRoute.Home.name) {
            HomeScreen()
        }
    }
}