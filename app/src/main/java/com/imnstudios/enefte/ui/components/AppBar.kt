package com.imnstudios.enefte.ui.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.imnstudios.enefte.R


@Composable
fun AppBar(
    modifier: Modifier,
    title: @Composable () -> Unit = {},
    backgroundColor: Color = MaterialTheme.colors.background,
    actions: @Composable () -> Unit = {},
    onNavIconPress: () -> Unit
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.statusBarsPadding())
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {},
                backgroundColor = backgroundColor,
                navigationIcon = {
                    IconButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp),
                        onClick = { onNavIconPress() }) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_arrow_left),
                            contentDescription = ""
                        )
                    }
                },
                actions = { actions() },
                elevation = 0.dp
            )
            title()
        }

    }

}