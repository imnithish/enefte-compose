@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package com.imnstudios.enefte.ui.screens.connect

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.imnstudios.enefte.R
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
        sheetContent = {
            Box(Modifier.size(100.dp)) {

            }
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
        ) {

            Box(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                TextFieldModal(modifier = Modifier.fillMaxWidth())
            }

        }
    }

}