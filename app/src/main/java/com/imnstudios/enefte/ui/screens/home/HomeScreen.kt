@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.imnstudios.enefte.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.imnstudios.enefte.R
import com.imnstudios.enefte.ui.components.BalanceLayout

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier.navigationBarsPadding(),
                navController = navController
            )
        }
    ) {
        HomeNavigation(modifier = Modifier.padding(it), navController = navController)
    }
}