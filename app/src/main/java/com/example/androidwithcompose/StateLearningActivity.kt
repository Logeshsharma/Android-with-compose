package com.example.androidwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class StateLearningActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val color = remember {
                mutableStateOf(Color.Yellow)
            }
            Column {
                ColorBox(modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(), updateColor = {
                    color.value = it
                })
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .background(color = color.value)
                        .fillMaxSize()
                )
            }


        }
    }

}

@Composable
fun ColorBox(modifier: Modifier, updateColor: (Color) -> Unit) {


    Box(modifier = modifier

        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        }

    )

}