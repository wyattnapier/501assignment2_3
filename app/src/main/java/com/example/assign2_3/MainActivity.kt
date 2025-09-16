package com.example.assign2_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assign2_3.ui.theme.Assign2_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assign2_3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    ClickCounter(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun ClickCounter(modifier: Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    Button(onClick = {count = calculateCount(count)}) {
        Text(text = "I've been clicked $count times")
    }
}

fun calculateCount(c: Int): Int {
    return if(c < 5) {
        c + 1
    } else {
        c
    }
}

@Preview(showBackground = true)
@Composable
fun ClickCounterPreview() {
    Assign2_3Theme {
        ClickCounter(modifier = Modifier)
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assign2_3Theme {
        Greeting("Android")
    }
}