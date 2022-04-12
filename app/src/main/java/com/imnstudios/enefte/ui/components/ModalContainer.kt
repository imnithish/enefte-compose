package com.imnstudios.enefte.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.imnstudios.enefte.ui.theme.RoundRectangle
import com.imnstudios.enefte.ui.theme.gray_light

@Composable
fun ModalContainer(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RoundRectangle(
            modifier = Modifier
                .height(5.dp)
                .width(97.dp),
            color = gray_light,
            cornerRadiusX = 2.dp,
            cornerRadiusY = 2.dp
        )
        Spacer(modifier = Modifier.height(12.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            backgroundColor = MaterialTheme.colors.background
        ) {
            content()
        }
    }

}