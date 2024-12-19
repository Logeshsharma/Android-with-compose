package com.example.androidwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidwithcompose.ui.theme.AndroidwithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val painter = painterResource(R.drawable.images)
            val description = "We can see a car in the snow"
            val title = "We can see a car in the snow"
            Box(modifier = Modifier.fillMaxWidth(0.5f)) {
                ImageCard(painter = painter, title = title, description = description)
            }
        }
    }
}

@Composable
fun ImageCard(painter: Painter, title: String, description: String, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),

        ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = description,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black), startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }

    }

}

@Composable
fun AndroidWithCompose() {
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
