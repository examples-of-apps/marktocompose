package com.harukadev.myapplication.marktocompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jsoup.nodes.Element

@Composable
fun MarkHeading(modifier: Modifier = Modifier, element: Element, level: Int) {
    MarkHeadingRaw(modifier, element, level)
}

@Preview(showBackground = true)
@Composable
private fun MarkHeadingPreview() {
    MarkHeadingRaw(element = Element("# hello"))
}

@Composable
private fun MarkHeadingRaw(modifier: Modifier = Modifier, element: Element, level: Int = 1) {
    val text = element.text()

    when (level) {
        1 -> Text(
            text,
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .then(modifier),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(color = Color.Black, background = Color.Transparent)
        )

        2 -> Text(
            text,
            Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
                .then(modifier),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        3 -> Text(
            text,
            Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .then(modifier),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        4 -> Text(
            text,
            Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp)
                .then(modifier),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        5 -> Text(
            text,
            Modifier
                .fillMaxWidth()
                .padding(vertical = 1.dp)
                .then(modifier),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        6 -> Text(
            text,
            Modifier
                .fillMaxWidth()
                .then(modifier),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}