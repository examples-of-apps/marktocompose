package com.harukadev.myapplication.marktocompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.harukadev.myapplication.marktocompose.components.MarkHeading
import com.harukadev.myapplication.marktocompose.components.MarkImage
import com.harukadev.myapplication.marktocompose.components.MarkLink
import com.harukadev.myapplication.marktocompose.components.MarkText
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.nodes.Node
import org.jsoup.nodes.TextNode

fun parseMarkdownToHTML(markdown: String): String {
    val flavour = CommonMarkFlavourDescriptor()
    val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(markdown)
    return HtmlGenerator(markdown, parsedTree, flavour).generateHtml().replace("<p>", "")
        .replace("</p>", "")
}

@Composable
fun HtmlToComposable(markdown: String) {
    val html = parseMarkdownToHTML(markdown)
    val document: Document = Jsoup.parse(html)

    Column(modifier = Modifier.padding(16.dp)) {
        document.body().childNodes().forEach { node ->
            RenderNode(node)
        }
    }
}

@Composable
fun RenderNode(node: Node) {
    when (node) {
        is TextNode -> {
            MarkText(element = Element(node.text()))
        }

        is Element -> {
            when (node.tagName()) {
                "p" -> MarkText(element = node)
                "img" -> MarkImage(element = node)
                "h1" -> MarkHeading(
                    element = node,
                    level = 1
                )

                "h2" -> MarkHeading(
                    element = node,
                    level = 2
                )

                "h3" -> MarkHeading(
                    element = node,
                    level = 3
                )

                "h4" -> MarkHeading(
                    element = node,
                    level = 4
                )

                "h5" -> MarkHeading(
                    element = node,
                    level = 5
                )

                "h6" -> MarkHeading(
                    element = node,
                    level = 6
                )

                "a" -> MarkLink(element = node)
                else -> println("Element type not supported: ${node.tagName()}")
            }
        }
    }
}