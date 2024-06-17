package com.example.logincompose.app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen(){
    object SignUpScreen : Screen()
    object TerminosCondicionesScreen : Screen()
}

object PostOfficeAppRouter{
    val pantallaConcurrente : MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)

    fun navigateTo(destino: Screen){
        pantallaConcurrente.value = destino
    }
}