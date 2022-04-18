package com.imnstudios.enefte.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Button(
    modifier: Modifier = Modifier,
    backGroundColor: Color = MaterialTheme.colors.primary,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {

    androidx.compose.material.Button(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minHeight = 49.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backGroundColor,
            contentColor = MaterialTheme.colors.onBackground
        ),
        content = content
    )

}