package com.imnstudios.enefte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.imnstudios.enefte.navigation.Navigation
import com.imnstudios.enefte.ui.theme.DarkColorPalette
import com.imnstudios.enefte.ui.theme.EnefteTheme
import com.imnstudios.enefte.ui.theme.white

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val systemUIController = rememberSystemUiController()

            SideEffect {
                systemUIController.apply {
                    setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = false,
                    )
                    setStatusBarColor(
                        color = Color.Transparent,
                        darkIcons = false
                    )
                }
            }
            EnefteTheme(colors = DarkColorPalette) {
                Navigation()
            }
        }
    }
}
