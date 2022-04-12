@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package com.imnstudios.enefte.ui.screens.connect

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.imnstudios.enefte.R
import com.imnstudios.enefte.ui.components.ImageButton
import com.imnstudios.enefte.ui.components.ModalContainer
import com.imnstudios.enefte.ui.theme.gray_light
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ConnectScreen(
    navController: NavController
) {

    val state = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    val handleBackPress: () -> Unit = {
        if (state.isVisible)
            scope.launch {
                state.hide()
            }
        else
            navController.popBackStack()
    }
    BackHandler(true) {
        handleBackPress()
    }

    ModalBottomSheetLayout(
        sheetState = state,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetBackgroundColor = Color.Transparent,
        sheetContent = {
            ModalContainer(content = {
                TextFieldModal(
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 44.dp),
                    onConfirmClick = { navController.navigate("setup_profile") })
            })
        }
    ) {
        Scaffold(
            topBar = {
                com.imnstudios.enefte.ui.components.AppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_logo),
                            contentDescription = ""
                        )
                    },
                    onNavIconPress = {
                        handleBackPress()
                    })
            }
        ) { it ->
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(207.dp),
                    painter = painterResource(id = R.drawable.wallet),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .padding(start = 34.dp, end = 34.dp, top = 16.dp),
                    text = "Choose your wallet",
                    style = MaterialTheme.typography.h1
                )

                Text(
                    modifier = Modifier
                        .padding(start = 34.dp, end = 34.dp, top = 16.dp),
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = gray_light)) {
                            append("By connecting your wallet you agree to our ")
                        }
                        append("Terms of Service")
                        withStyle(style = SpanStyle(color = gray_light)) {
                            append(" and ")
                        }
                        append("Privacy Policy")
                    },
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(30.dp))

                listOf(
                    Pair(painterResource(id = R.drawable.metamask), "MetaMask"),
                    Pair(painterResource(id = R.drawable.trust), "Trust Wallet"),
                    Pair(painterResource(id = R.drawable.ic_address), "Enter ethereum address"),
                ).forEach {
                    ImageButton(
                        modifier = Modifier.padding(horizontal = 24.dp),
                        text = it.second,
                        image = it.first
                    ) {
                        scope.launch {
                            state.show()
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }

                Spacer(modifier = Modifier.height(32.dp))

                com.imnstudios.enefte.ui.components.Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                    onClick = {
                    }) {
                    Text(
                        text = "Continue",
                        style = MaterialTheme.typography.button
                    )
                }
                Spacer(modifier = Modifier.height(48.dp))

            }
        }
    }

}