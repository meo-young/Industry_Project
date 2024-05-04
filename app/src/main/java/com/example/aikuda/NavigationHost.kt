package com.example.aikuda

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route
    ){
        composable(NavRoutes.Home.route){
            mainScreen()
        }
        /*composable(NavRoutes.Appointment.route){
            Appointment()
        }*/
        /*composable(NavRoutes.Mypage.route){
            MyPage()
        }*/
    }
}