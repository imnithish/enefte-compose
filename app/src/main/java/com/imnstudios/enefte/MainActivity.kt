package com.imnstudios.enefte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imnstudios.enefte.ui.theme.DarkColorPalette
import com.imnstudios.enefte.ui.theme.EnefteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnefteTheme(colors = DarkColorPalette) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello $name!", style = MaterialTheme.typography.h1)
        Text(text = "Hello $name!", style = MaterialTheme.typography.h2)
        Text(text = "Hello $name!", style = MaterialTheme.typography.body1)
        Text(text = "Hello $name!", style = MaterialTheme.typography.button)
        Text(text = "Hello $name!", style = MaterialTheme.typography.caption)
        Text(text = "Hello $name!", style = MaterialTheme.typography.overline)

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EnefteTheme {
        Greeting("Android")
    }
}