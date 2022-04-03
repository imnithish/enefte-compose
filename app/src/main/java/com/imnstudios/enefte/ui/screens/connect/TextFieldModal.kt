package com.imnstudios.enefte.ui.screens.connect

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.imnstudios.enefte.ui.theme.gray_light
import com.imnstudios.enefte.ui.theme.white

@Composable
fun TextFieldModal(
    modifier: Modifier = Modifier
) {
    val text = rememberSaveable { mutableStateOf("") }

    Card(
        border = BorderStroke(1.dp, Color.White),
        backgroundColor = MaterialTheme.colors.secondary,
        elevation = 0.dp
    ) {
        TextField(
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
            )
        )
    }
}