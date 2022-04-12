package com.imnstudios.enefte.ui.screens.setupprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.imnstudios.enefte.R

@Composable
fun WelcomeScreen(
    triggerLaunch: () -> Unit
) {

    LaunchedEffect(Unit) {
        triggerLaunch()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {


        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.size(207.dp),
                painter = painterResource(id = R.drawable.paint),
                contentDescription = ""
            )

            Text(
                modifier = Modifier
                    .padding(start = 45.dp, end = 45.dp, top = 40.dp),
                text = "Hey! Welcome",
                style = MaterialTheme.typography.h1
            )

            Text(
                modifier = Modifier
                    .padding(start = 45.dp, end = 45.dp, top = 16.dp),
                text = "Create and Sell your NFT in 1 seconds",
                style = MaterialTheme.typography.body1
            )
        }


    }
}