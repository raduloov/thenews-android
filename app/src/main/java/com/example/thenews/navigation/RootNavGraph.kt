package com.example.thenews.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thenews.ui.MainScreen
import com.example.thenews.ui.auth.*

@Composable
fun RootNavGraph(
    authViewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Graph.AUTH,
    darkTheme: Boolean
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
        route = Graph.ROOT
    ) {
        authNavGraph(navController, authViewModel)
        loggedInNavGraph(navController, authViewModel)
    }
}

object Graph {
    const val ROOT = "ROOT_GRAPH"
    const val AUTH = "AUTH_GRAPH"
    const val LOGGED_IN = "LOGGED_IN_GRAPH"
}