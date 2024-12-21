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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidwithcompose.ui.theme.AndroidwithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            ExploreText()
        }
    }
}

@Composable
fun ExploreText() {
    val fontFamily = FontFamily(
        Font(R.font.rasa_bold, FontWeight.Bold),
        Font(R.font.rasa_light, FontWeight.Thin),
        Font(R.font.rasa_medium, FontWeight.Normal)
    )
    Scaffold(
        topBar = { MySmallAppBar() },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
            ) {
                Text(
                    "Explore String",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(paddingValues),
                    fontFamily = fontFamily
                )
            }
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySmallAppBar() {
    TopAppBar(
        title = { Text("Small AppBar") },
        navigationIcon = {
            IconButton(onClick = { /* Handle navigation */ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = { /* Handle action */ }) {
                Icon(Icons.Default.MoreVert, contentDescription = "More options")
            }
        }
    )
}


@Composable
fun ImageCardContent() {
    val painter = painterResource(R.drawable.images)
    val description = "We can see a car in the snow"
    val title = "We can see a car in the snow"
    Box(modifier = Modifier.fillMaxWidth(0.5f)) {
        ImageCard(painter = painter, title = title, description = description)
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
