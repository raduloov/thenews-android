package com.example.thenews.ui.components.auth

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thenews.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository = AuthRepository()
) : ViewModel() {
    val currentUser = repository.currentUser

    val hasUser: Boolean
        get() = repository.hasUser()

    var authUiState by mutableStateOf(AuthUiState())
        private set

    fun onUsernameChange(username: String) {
        authUiState = authUiState.copy(username = username)
    }

    fun onPasswordChange(password: String) {
        authUiState = authUiState.copy(password = password)
    }

    fun onUsernameChangeSignUp(username: String) {
        authUiState = authUiState.copy(usernameSignUp = username)
    }

    fun onPasswordChangeSignUp(password: String) {
        authUiState = authUiState.copy(passwordSignUp = password)
    }

    fun onConfirmPasswordChange(password: String) {
        authUiState = authUiState.copy(confirmPasswordSignUp = password)
    }

    private fun validateLoginForm(): Boolean {
        return authUiState.username.isNotBlank() && authUiState.password.isNotBlank()
    }

    private fun validateSignUpForm(): Boolean {
        return authUiState.usernameSignUp.isNotBlank() &&
                authUiState.passwordSignUp.isNotBlank() &&
                authUiState.confirmPasswordSignUp.isNotBlank()
    }

    fun createUser(context: Context) = viewModelScope.launch {
        try {
            if (!validateSignUpForm()) {
                throw java.lang.IllegalArgumentException("Email and password can not be empty.")
            }

            authUiState = authUiState.copy(isLoading = true)
            if (authUiState.passwordSignUp != authUiState.confirmPasswordSignUp) {
                throw java.lang.IllegalArgumentException("Passwords do not match.")
            }

            authUiState = authUiState.copy(signUpError = null)

            repository.createUser(
                authUiState.usernameSignUp,
                authUiState.passwordSignUp
            ) { isSuccessful ->
                if (isSuccessful) {
                    Toast.makeText(context, "success login", Toast.LENGTH_SHORT).show()
                    authUiState = authUiState.copy(isSuccessLogin = true)
                } else {
                    Toast.makeText(context, "success failed", Toast.LENGTH_SHORT).show()
                    authUiState = authUiState.copy(isSuccessLogin = false)
                }
            }
        } catch (e: Exception) {
            authUiState = authUiState.copy(signUpError = e.localizedMessage)
            e.printStackTrace()
        } finally {
            authUiState = authUiState.copy(isLoading = false)
        }
    }

    fun loginUser(context: Context) = viewModelScope.launch {
        try {
            if (!validateLoginForm()) {
                throw java.lang.IllegalArgumentException("Email and password can not be empty.")
            }

            authUiState = authUiState.copy(isLoading = true)
            authUiState = authUiState.copy(loginError = null)

            repository.loginUser(
                authUiState.username,
                authUiState.password
            ) { isSuccessful ->
                if (isSuccessful) {
                    Toast.makeText(context, "success login", Toast.LENGTH_SHORT).show()
                    authUiState = authUiState.copy(isSuccessLogin = true)
                } else {
                    Toast.makeText(context, "success failed", Toast.LENGTH_SHORT).show()
                    authUiState = authUiState.copy(isSuccessLogin = false)
                }
            }
        } catch (e: Exception) {
            authUiState = authUiState.copy(loginError = e.localizedMessage)
            e.printStackTrace()
        } finally {
            authUiState = authUiState.copy(isLoading = false)
        }
    }
}

data class AuthUiState(
    val username: String = "",
    val password: String = "",
    val usernameSignUp: String = "",
    val passwordSignUp: String = "",
    val confirmPasswordSignUp: String = "",
    val isLoading: Boolean = false,
    val isSuccessLogin: Boolean = false,
    val signUpError: String? = "",
    val loginError: String? = ""
)