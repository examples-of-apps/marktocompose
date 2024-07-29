package com.harukadev.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.harukadev.myapplication.marktocompose.HtmlToComposable
import com.harukadev.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                App()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun App() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val markdown = """
        # Heading level 1
        ## Heading level 2
        ### Heading level 3
        #### Heading level 4
        ##### Heading level 5
        ###### Heading level 6
        
        I really like using Markdown.
        
        ![figure](https://imgur.com/7g6HrBS.jpg)
        
        [This is a link](https://www.tabnews.com.br/)
        
        ```kotlin
        fun main() {
            println("Hello, World!")
        }
        ```
    """.trimIndent()
        HtmlToComposable(markdown)
    }
}