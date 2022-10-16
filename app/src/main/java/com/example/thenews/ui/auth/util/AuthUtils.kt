package com.example.thenews.ui.auth.util

fun getAuthErrorMessage(message: String): String {
    return when (message) {
        "Given String is empty or null" -> "Please fill out all fields."
        "The given password is invalid. [ Password should be at least 6 characters. ]" ->
            "Password should be at least 6 characters."
        else -> message
    }
}