package com.harukadev.myapplication.marktocompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.jsoup.nodes.Element

@Composable
fun MarkDiv(modifier: Modifier = Modifier, element: Element) {
    MarkDivRaw(modifier, element)
}

@Preview(showBackground = true)
@Composable
private fun MarkDivPreview() {
    MarkDivRaw(element = Element("<div>"))
}

@Composable
private fun MarkDivRaw(modifier: Modifier = Modifier, element: Element) {
    Text(element.text(), Modifier.fillMaxWidth().then(modifier))
}