package com.imnstudios.enefte.ui.screens.connect

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.unit.dp
import com.imnstudios.enefte.ui.theme.gray_light
import com.imnstudios.enefte.ui.theme.white

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldModal(
    modifier: Modifier = Modifier,
    onConfirmClick: (String) -> Unit
) {
    val text = rememberSaveable { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(modifier.imePadding()) {
        Text(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "Enter ethereum address",
            style = MaterialTheme.typography.h2
        )

        Card(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            border = BorderStroke(1.dp, Color.White),
            backgroundColor = MaterialTheme.colors.secondary,
            elevation = 0.dp
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text.value,
                onValueChange = {
                    text.value = it
                },
                shape = RoundedCornerShape(12.dp),
                label = { Text("Address") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    cursorColor = white,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedLabelColor = gray_light,
                    focusedLabelColor = gray_light
                ),
                keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                )
            )
        }

        com.imnstudios.enefte.ui.components.Button(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, bottom = 24.dp),
            onClick = {
                onConfirmClick(text.value)
            }) {
            Text(
                text = "Confirm",
                style = MaterialTheme.typography.button
            )
        }
    }

}