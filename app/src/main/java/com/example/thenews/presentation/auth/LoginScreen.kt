package com.example.thenews.presentation.auth

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.thenews.data.Resource
import com.example.thenews.navigation.ROUTE_HOME
import com.example.thenews.navigation.ROUTE_LOGIN
import com.example.thenews.navigation.ROUTE_SIGNUP
import com.example.thenews.ui.theme.TheNewsTheme

@Composable
fun LoginScreen(viewModel: AuthViewModel?, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val authResource = viewModel?.loginFlow?.collectAsState()

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {

        val (refHeader, refEmail, refPassword, refButtonLogin, refTextSignup, refLoading) = createRefs()

        Box(
            modifier = Modifier
                .constrainAs(refHeader) {
                    top.linkTo(parent.top, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .wrapContentSize()
        ) {
//            AuthHeader()
        }


        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
//                Text(text = stringResource(id = R.string.email))
                Text(text = "Email")
            },
            modifier = Modifier.constrainAs(refEmail) {
                top.linkTo(refHeader.bottom, 16.dp)
                start.linkTo(parent.start, 14.dp)
                end.linkTo(parent.end, 14.dp)
                width = Dimension.fillToConstraints
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
//                Text(text = stringResource(id = R.string.password))
                Text(text = "Password")
            },
            modifier = Modifier.constrainAs(refPassword) {
                top.linkTo(refEmail.bottom, 10.dp)
                start.linkTo(parent.start, 14.dp)
                end.linkTo(parent.end, 14.dp)
                width = Dimension.fillToConstraints
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )

        Button(
            onClick = {
                viewModel?.loginUser(email, password)
            },
            modifier = Modifier.constrainAs(refButtonLogin) {
                top.linkTo(refPassword.bottom, 14.dp)
                start.linkTo(parent.start, 16.dp)
                end.linkTo(parent.end, 16.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            Text(text = "Login", style = MaterialTheme.typography.h3)
        }


        Text(
            modifier = Modifier
                .constrainAs(refTextSignup) {
                    top.linkTo(refButtonLogin.bottom, 10.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                }
                .clickable {
                    navController.navigate(ROUTE_SIGNUP) {
                        popUpTo(ROUTE_LOGIN) { inclusive = true }
                    }
                },
//            text = stringResource(id = R.string.dont_have_account),
            text = "Don't have and account?",
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onSurface
        )

        authResource?.value?.let {
            when (it) {
                is Resource.Failure -> {
                    Toast.makeText(LocalContext.current, "Error ${it.exception.message.toString()}", Toast.LENGTH_SHORT).show()
//                    ShowToast(message = it.exception.message.toString())
                }
                is Resource.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.constrainAs(refLoading) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })
                }
                is Resource.Success -> {
                    LaunchedEffect(Unit) {
                        navController.navigate(ROUTE_HOME) {
                            popUpTo(ROUTE_LOGIN) { inclusive = true }
                        }
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
//    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun LoginScreenPreviewLight() {
    TheNewsTheme {
        LoginScreen(null, rememberNavController())
    }
}

@Preview(
    showBackground = true,
//    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun LoginScreenPreviewDark() {
    TheNewsTheme {
        LoginScreen(null, rememberNavController())
    }
}