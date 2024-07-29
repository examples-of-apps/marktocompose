package com.harukadev.myapplication.marktocompose.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import org.jsoup.nodes.Element

@Composable
fun MarkImage(modifier: Modifier = Modifier, element: Element) {
    MarkImageRaw(modifier, element)
}

@Preview(showBackground = true)
@Composable
private fun MarkImagePreview() {
    MarkImageRaw(element = Element("<img src=\"imagem.jpg\" alt=\"Minha Figura\">"))
}

@Composable
private fun MarkImageRaw(
    modifier: Modifier = Modifier,
    element: Element
) {
    val src = element.absUrl("src")
    val alt = element.absUrl("alt")
    AsyncImage(
        model = src,
        contentDescription = alt, Modifier
            .then(modifier)
    )
}