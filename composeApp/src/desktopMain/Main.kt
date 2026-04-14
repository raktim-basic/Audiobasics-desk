package com.audiobasics.desk

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    val state = rememberWindowState(width = 1100.dp, height = 720.dp)
    Window(
        onCloseRequest = ::exitApplication,
        title = "Audiobasics Desk",
        state = state
    ) {
        App()
    }
}
