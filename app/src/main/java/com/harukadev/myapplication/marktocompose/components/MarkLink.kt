package com.harukadev.myapplication.marktocompose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import org.jsoup.nodes.Element

@Composable
fun MarkLink(
    modifier: Modifier = Modifier,
    element: Element,
    style: TextStyle = TextStyle(),
) {
    MarkLinkRaw(modifier, element, style)
}

@Preview(showBackground = true)
@Composable
private fun MarkLinkPreview() {
    MarkLinkRaw(element = Element("<a href=\"https://www.tabnews.com.br/\">TabNews</a>"))
}

@Composable
private fun MarkLinkRaw(
    modifier: Modifier = Modifier,
    element: Element,
    style: TextStyle = TextStyle(),
) {
    println(element)
    val uriHandler = LocalUriHandler.current
    val url = element.absUrl("href")

    Text(
        text = element.text(),
        style = TextStyle(
            color = Color.Black,
            textDecoration = TextDecoration.Underline,
        ).merge(style),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                uriHandler.openUri(url)
            }
            .then(modifier)
    )
}