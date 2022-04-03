package com.imnstudios.enefte.ui.theme

import android.graphics.ColorMatrix
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp)
)


@Composable
fun RoundRectangle(
    modifier: Modifier,
    color: Color,
    cornerRadiusX: Dp = 16.dp,
    cornerRadiusY: Dp = 16.dp
) {
    Canvas(modifier = modifier, onDraw = {
        drawRoundRect(
            color = color,
            cornerRadius = CornerRadius(x = cornerRadiusX.toPx(), y = cornerRadiusY.toPx())
        )
    })
}