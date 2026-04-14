package com.audiobasics.desk

import androidx.compose.runtime.*
import androidx.compose.material3.MaterialTheme
import com.audiobasics.desk.ui.PairingScreen

enum class Screen { PAIRING, HOME }

@Composable
fun App() {
    var screen by remember { mutableStateOf(Screen.PAIRING) }

    MaterialTheme {
        when (screen) {
            Screen.PAIRING -> PairingScreen(onPaired = { screen = Screen.HOME })
            Screen.HOME    -> HomeScreen()
        }
    }
}
