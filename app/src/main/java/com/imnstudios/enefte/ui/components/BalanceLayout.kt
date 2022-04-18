package com.imnstudios.enefte.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imnstudios.enefte.R
import com.imnstudios.enefte.ui.theme.DarkColorPalette
import com.imnstudios.enefte.ui.theme.EnefteTheme
import com.imnstudios.enefte.ui.theme.gray_light
import com.imnstudios.enefte.ui.theme.white

@Composable
fun BalanceLayout(
    modifier: Modifier = Modifier,
    balance: String
) {
    Box(modifier = modifier.wrapContentSize().background(MaterialTheme.colors.background)) {

        Box(
            modifier = Modifier.align(Alignment.TopStart),
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                drawRoundRect(
                    color = gray_light,
                    size = Size(
                        width = 93.dp.toPx(),
                        height = 35.38.dp.toPx()
                    ),
                    style = Stroke(width = 1.dp.toPx()),
                    cornerRadius = CornerRadius(
                        x = 10.dp.toPx(),
                        y = 10.dp.toPx()
                    )
                )
            }

            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_ethereum),
                    contentDescription = ""
                )

                Text(
                    modifier = Modifier
                        .padding(start = 12.dp),
                    text = balance,
                    style = MaterialTheme.typography.button
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(width = 56.dp, height = 14.dp).padding(bottom = 2.dp)
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Balance",
                style = MaterialTheme.typography.overline,
                color = white,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun BalanceLayoutPreview() {
    EnefteTheme(colors = DarkColorPalette) {
        BalanceLayout(balance = "26,031", modifier = Modifier.size(width = 93.dp, height = 43.dp))
    }
}