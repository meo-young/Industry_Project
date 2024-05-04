package com.example.aikuda

sealed class NavRoutes (val route: String) {
    object Home : NavRoutes("Home")
    object Appointment : NavRoutes("Appointment")
    object Mypage : NavRoutes("Mypage")

}