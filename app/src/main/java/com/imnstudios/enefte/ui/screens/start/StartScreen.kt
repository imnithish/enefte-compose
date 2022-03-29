package com.imnstudios.enefte.ui.screens.start

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import com.imnstudios.enefte.ui.theme.gray
import com.imnstudios.enefte.ui.theme.gray_light
import com.imnstudios.enefte.ui.theme.primary

@Composable
fun StartScreen() {
    Box(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.TopStart)
        ) {
            Canvas(modifier = Modifier
                .width(210.dp)
                .height(190.dp),
                onDraw = {
                    drawArc(
                        color = gray,
                        startAngle = 0f,
                        sweepAngle = 360f,
                        topLeft = Offset(-120f, -110f),
                        useCenter = false,
                        style = Stroke(width = 8f)
                    )
                })
        }

        Box(
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.TopStart)
        ) {
            Canvas(modifier = Modifier
                .width(210.dp)
                .height(190.dp), onDraw = {
                drawArc(
                    color = primary,
                    startAngle = 0f,
                    sweepAngle = 360f,
                    topLeft = Offset(-120f, -110f),
                    useCenter = false,
                    style = Stroke(width = 8f)
                )
            })
        }


    }
}