package com.imnstudios.enefte.ui.screens.setupprofile

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.imnstudios.enefte.R
import com.imnstudios.enefte.ui.components.AppBar
import com.imnstudios.enefte.ui.theme.gray_light
import com.imnstudios.enefte.ui.theme.white
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SetupProfile(onNavIconPress: () -> Unit, onSubmit: () -> Unit) {

    val username = rememberSaveable { mutableStateOf("") }
    val email = rememberSaveable { mutableStateOf("") }
    val bio = rememberSaveable { mutableStateOf("") }
    var showWelcomeScreen by remember { mutableStateOf(false) }


    val scope = rememberCoroutineScope()
    val startCountDown: () -> Unit = {
        scope.launch {
            delay(1500L)
            onSubmit()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                AppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_logo),
                            contentDescription = ""
                        )
                    },
                    onNavIconPress = onNavIconPress
                )
            }
        ) { it ->
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .imePadding()
                    .navigationBarsPadding()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 52.dp),
                    text = "Upload Photo Profile",
                    style = MaterialTheme.typography.body1
                )

                Row(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(148.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.cucumber),
                        contentDescription = ""
                    )

                    OutlinedButton(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .height(49.dp)
                            .weight(1f),
                        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = MaterialTheme.colors.background,
                            contentColor = white
                        ),
                        onClick = { }
                    ) {
                        Text(
                            text = "Upload photo",
                            style = MaterialTheme.typography.button,
                            color = white
                        )
                    }
                }

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, top = 32.dp)
                        .defaultMinSize(minHeight = 56.dp),
                    value = username.value,
                    onValueChange = {
                        username.value = it
                    },
                    shape = RoundedCornerShape(12.dp),
                    label = { Text("Username", style = MaterialTheme.typography.overline) },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        cursorColor = white,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedLabelColor = gray_light,
                        focusedLabelColor = gray_light
                    ),
                    textStyle = MaterialTheme.typography.caption
                )

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, top = 32.dp)
                        .defaultMinSize(minHeight = 56.dp),
                    value = email.value,
                    onValueChange = {
                        email.value = it
                    },
                    shape = RoundedCornerShape(12.dp),
                    label = { Text("Email", style = MaterialTheme.typography.overline) },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        cursorColor = white,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedLabelColor = gray_light,
                        focusedLabelColor = gray_light
                    ),
                    textStyle = MaterialTheme.typography.caption
                )

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, top = 32.dp)
                        .defaultMinSize(minHeight = 109.dp),
                    value = bio.value,
                    onValueChange = {
                        bio.value = it
                    },
                    shape = RoundedCornerShape(12.dp),
                    label = { Text("Bio", style = MaterialTheme.typography.overline) },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        cursorColor = white,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedLabelColor = gray_light,
                        focusedLabelColor = gray_light
                    ),
                    textStyle = MaterialTheme.typography.caption
                )

                com.imnstudios.enefte.ui.components.Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 48.dp),
                    onClick = {
                        showWelcomeScreen = true
                    }) {
                    Text(text = "Submit", style = MaterialTheme.typography.button)
                }
            }
        }


        AnimatedVisibility(
            visible = showWelcomeScreen,
            enter = slideInVertically() + fadeIn()
        ) {
            WelcomeScreen {
                startCountDown()
            }

        }

    }

}