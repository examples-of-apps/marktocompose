package com.harukadev.myapplication.marktocompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jsoup.nodes.Element

@Composable
fun MarkText(modifier: Modifier = Modifier, element: Element) {
    MarkTextRaw(modifier, element)
}

@Composable
private fun MarkTextPreview() {
    MarkTextRaw(element = Element("this is a text"))
}

@Composable
private fun MarkTextRaw(modifier: Modifier = Modifier, element: Element) {
    Text(element.text(),
        Modifier
            .fillMaxWidth()
            .then(modifier))
}