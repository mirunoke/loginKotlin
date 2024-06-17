package com.example.logincompose.navigation

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalBackPressedDispatcher = staticCompositionLocalOf<OnBackPressedDispatcher?> { null }

private class ComposableBackNavigationHandler(enabled : Boolean) : OnBackPressedCallback(enabled)
{
    lateinit var onBackPressed : () -> Unit

    override fun handleOnBackPressed() {
        onBackPressed()
    }
}

@Composable
internal fun ComposableHandler(
    enabled : Boolean = true,
    onBackPressed : () -> Unit = {
        val dispatcher = (LocalBackPressedDispatcher.current ?:return).onBackPressedDispatcher
        val handler = remember {ComposableBackNavigationHandler(enabled)}
        DisposableEffect(dispatcher) {
            dispatcher.addCallback(handler)
            onDispose {handler.remove()
            }
        LaunchedEffect(enabled) {
            handler.isEnabled = enabled
            handler.onBackPressed = onBackPressed
        }
        }
    },
)