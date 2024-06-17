package com.example.logincompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.logincompose.R
import com.example.logincompose.app.PostOfficeAppRouter
import com.example.logincompose.app.Screen
import com.example.logincompose.components.*

@Composable
fun SignUpScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            NormalTextComponents(value =  "Hey, Registrate")
            HeadingTextComponents(value  = "Crea una cuenta")

            Spacer(modifier = Modifier.height(20.dp))
            TextFieldName(
                labelValue  = "Nombre",
                painterResource(id = R.drawable.baseline_co_present_24)
            )

            Spacer(modifier = Modifier.height(8.dp))
            TextFieldName(
                labelValue = "Apellidos",
                painterResource(id = R.drawable.baseline_person_add_24)
            )

            Spacer(modifier = Modifier.height(8.dp))
            TextFieldName(
                labelValue  = "Email",
                painterResource(id = R.drawable.baseline_email_24)
            )

            Spacer(modifier = Modifier.height(8.dp))
            TextFieldName(
                labelValue  ="Password",
                painterResource(id = R.drawable.baseline_fingerprint_24)
            )

            CheckBoxComponent(
                value =  "Para continuar deberás aceptar los terminos y condiciones",
                onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.TerminosCondicionesScreen)
                }
            )

            Spacer(modifier = Modifier.height(20.dp))
            ButtonComponent(value =  "Registrate")
            Spacer(modifier = Modifier.height(10.dp))
            DividerTextComponent()
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}