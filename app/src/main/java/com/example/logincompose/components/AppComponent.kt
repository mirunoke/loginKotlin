package com.example.logincompose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import mx.edu.udg.cucei.logincompose.R.color
import mx.edu.udg.cucei.logincompose.ui.theme.Purple40
import mx.edu.udg.cucei.logincompose.ui.theme.Purple80

@Composable
fun NormalTextComponents(value: String){
    Text(text=value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = color.black),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponents(value: String){
    Text(text=value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = color.black),
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun TextFieldName (labelValue:String, painterResource: Painter)
{
    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        label = { Text(text = labelValue) },
        modifier = Modifier
            .fillMaxWidht()
            .border(
                BorderStroke(1.dp, Color.Gray)
            )
            .background(colorResource(id = color.placeholder_black)),
        colors = outlinedTextFieldColors(
          focusedBorderColor = colorResource(id = color.purple_700),
            focusedLabelColor = colorResource(id = color.purple_700),
            cursorColor = colorResource(id = color.purple_700)
        ),
        keyboardActions = KeyboardActions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource,
                contentDescription = "",)
        }
    )
}


@Composable
fun CheckBockComponent(value: String, onTextSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState = remember {
            mutableStateOf(false)
        }

        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value != checkedState.value
        })
        ClickableTextComponent(value = value, onTextSelected)
    }
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit){
    val inicialText = "Para continuar debes aceptar"
    val privacidadPoliticaText = "Terminos y Politicas de privacidad"
    val yText = "y"
    val terminosCondicionesText = "Terminos de uso"

    val anotacionString = buildAnnotatedString {
        append(inicialText)
        withStyle(
            style = SpanStyle(
                color = Color.Blue
            )
        ){
            pushStringAnnotation(
                tag = privacidadPoliticaText, annotation = privacidadPoliticaText
            )
            append(privacidadPoliticaText)
        }
        append(yText)
        withStyle(
            style = SpanStyle(
                color = Color.Blue
            )
        ){
            pushStringAnnotation(
                tag = terminosCondicionesText, annotation = terminosCondicionesText
            )
            append(terminosCondicionesText)
        }
    }

    //este metodo se encarga de generar un click sobre el texto seleccionado
    //offset se utilizara par aidentificar donse hace click el usuario
    ClickableText(text = anotacionString, onClick = { offset ->
        anotacionString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span.item}}")

                if ((span.item == terminosCondicionesText) || (span.item == privacidadPoliticaText)) {
                    onTextSelected(span.item)
                }
            }
    })
}

@Composable
fun ButtonComponent(value: String){
    Button(
        onClick ={},
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RoundedCornerShape(50.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Purple80, Purple40)),
                    shape = RoundedCornerShape(50.dp)
                ), contentAlignment = Alignment.Center
        ) {
            Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DividerTextComponent()
{
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .wight(1f),
            color = Purple40,
            thickness = 1.dp
        )
        Divider(modifier = Modifier
        .fillMaxWidth()
        .wight(1f),
        color = Purple40,
        thickness = 1.dp
)
}
}










