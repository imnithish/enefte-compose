package com.imnstudios.enefte.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.imnstudios.enefte.ui.screens.home.home.HomeSubScreen

@Composable
fun HomeNavigation(modifier: Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationItem.Home.route
    ) {
        composable(NavigationItem.Home.route) {
            HomeSubScreen()
        }
        composable(NavigationItem.Search.route) {
        }
        composable(NavigationItem.Stats.route) {
        }
        composable(NavigationItem.Profile.route) {
        }
        composable(NavigationItem.Profile.route) {
        }
    }
}