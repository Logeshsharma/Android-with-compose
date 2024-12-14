package com.example.androidwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidwithcompose.ui.theme.AndroidwithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidwithComposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GreetingText(
                        modifier = Modifier.padding(10.dp),
                        message = "Happy birthday",
                        name = "Logesh sharma"
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(modifier: Modifier = Modifier, message: String, name: String) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Top) {
        Text(
            text = message, fontSize = 24.sp, lineHeight = 100.sp, textAlign = TextAlign.Center
        )
        Text(
            text = name, fontSize = 20.sp, lineHeight = 200.sp, textAlign = TextAlign.Center
        )
    }
}


@Composable
fun FirstView(name: String, modifier: Modifier) {
    Text(
        text = name, modifier = modifier
    )
}
