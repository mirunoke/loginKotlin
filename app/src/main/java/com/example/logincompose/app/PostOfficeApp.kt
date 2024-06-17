package com.example.logincompose.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PostOfficeApp() {
    Surface(
        // Este modificador toma todo el espacio del componente llenando la altura y el largo principalmente
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Crossfade(targetState = PostOfficeAppRouter.pantallaConcurrente) { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }
                is Screen.TerminosCondicionesScreen -> {
                    TerminosCondicionesScreen()
                }
            }
        }
    }
}