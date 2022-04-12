package com.imnstudios.enefte.ui.screens.start

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.imnstudios.enefte.R
import com.imnstudios.enefte.ui.components.Button
import com.imnstudios.enefte.ui.screens.onboarding.Data
import com.imnstudios.enefte.ui.theme.gray
import com.imnstudios.enefte.ui.theme.primary
import kotlinx.coroutines.launch

@Composable
fun StartScreen(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {

        Box {
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

            Image(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 65.dp, start = 30.dp),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = ""
            )

        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .navigationBarsPadding()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    textAlign = TextAlign.Start,
                    text = "All NFTs are certifiably unique and ownable",
                    style = MaterialTheme.typography.h1
                )

                Text(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 24.dp),
                    textAlign = TextAlign.Start,
                    text = "A credible and excellent marketplace for non-fungible token.",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSecondary
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 111.dp, bottom = 48.dp, start = 24.dp, end = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Button(
                        modifier = Modifier.weight(2f),
                        onClick = onClick
                    ) {
                        Text(
                            text = "Connect with Wallet",
                            style = MaterialTheme.typography.button
                        )
                    }

                    OutlinedButton(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .height(48.dp)
                            .weight(1f),
                        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground),
                        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.background),
                        onClick = onClick
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = ""
                        )
                    }

                }

            }
        }


    }
}