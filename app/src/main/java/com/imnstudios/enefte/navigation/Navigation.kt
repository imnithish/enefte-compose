@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package com.imnstudios.enefte.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.imnstudios.enefte.ui.screens.connect.ConnectScreen
import com.imnstudios.enefte.ui.screens.onboarding.OnBoardingScreen
import com.imnstudios.enefte.ui.screens.start.StartScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = "connect",
    ) {
        composable(
            route = "on_boarding"
        ) {
            OnBoardingScreen(
                navController = navController
            )
        }

        composable(
            route = "start"
        ) {
            StartScreen()
        }

        composable(
            route = "connect"
        ) {
            ConnectScreen(navController = navController)
        }
    }

}