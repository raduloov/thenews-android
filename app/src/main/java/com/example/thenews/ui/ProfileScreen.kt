package com.example.thenews.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.thenews.navigation.Graph
import com.example.thenews.ui.auth.AuthViewModel

@Composable
fun ProfileScreen(
    viewModel: AuthViewModel?,
    navController: NavHostController
) {
    viewModel?.currentUser?.let {
        UserInfo(
            viewModel = viewModel,
            navController = navController,
            name = it.displayName.toString(),
            email = it.email.toString()
        )
    }
}

@Composable
fun UserInfo(
    viewModel: AuthViewModel?,
    navController: NavController,
    name: String,
    email: String
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp)
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Welcome back",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onSurface
        )

        Text(
            text = name,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onSurface
        )

//        Image(
//            painter = painterResource(id = R.drawable.ic_person),
//            contentDescription = null,
//            modifier = Modifier.size(128.dp)
//        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = "Name",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.weight(0.3f),
                    color = MaterialTheme.colors.onSurface
                )

                Text(
                    text = name,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.weight(0.7f),
                    color = MaterialTheme.colors.onSurface
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = "Email",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.weight(0.3f),
                    color = MaterialTheme.colors.onSurface
                )

                Text(
                    text = email,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.weight(0.7f),
                    color = MaterialTheme.colors.onSurface
                )
            }

            Button(
                onClick = {
                    viewModel?.logoutUser()
                    navController.navigate(Graph.AUTH) {
                        popUpTo(Graph.ROOT) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp)
            ) {
                Text(text = "Logout")
            }
        }
    }
}