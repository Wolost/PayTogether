package com.example.pt.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pt.R
import com.example.pt.Routes


@Composable
fun LoginPage(navController: NavHostController) {

    val backgroundColor = Color(0xFF33AAFE)

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(bottom = 80.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        //------------------FUNCION QUE SOLO PERMITE NÚMEROS-------------------//
        val onlyNumbersValidator: (String) -> Boolean = { newValue ->
            // Solo permitir números
            newValue.isEmpty() || newValue.isDigitsOnly()
        }

//------------------------------------LOGOTIPO--------------------------------------------------//
        Column(
            verticalArrangement = Arrangement.Top
        ) {
            val image = painterResource(R.drawable.logaso)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(top = 0.dp)
            )

        }
        Spacer(modifier = Modifier.height(20.dp))

//------------------------------------CIRCULOS PARA INICIAR SESIÓN--------------------------------------------------//

        Text(
            text = "Por Favor Ingrese su PIN de 5 dígitos",
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Row(
            modifier = Modifier
                .background(backgroundColor),
        ){
            val textFieldModifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .height(60.dp)
                .border(1.dp, Color.Gray, shape = CircleShape)

            val singleDigitModifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .padding(8.dp)

            val circle1 = remember { mutableStateOf("") }
            val circle2 = remember { mutableStateOf("") }
            val circle3 = remember { mutableStateOf("") }
            val circle4 = remember { mutableStateOf("") }
            val circle5 = remember { mutableStateOf("") }

            val circleValues = listOf(circle1.value, circle2.value, circle3.value, circle4.value, circle5.value)
            val enteredPin = circleValues.joinToString("")

            val onValueChange: (Int, String) -> Unit = { index, value ->
                if (onlyNumbersValidator(value) && value.length == 1) {
                    when (index) {
                        0 -> circle1.value = value
                        1 -> circle2.value = value
                        2 -> circle3.value = value
                        3 -> circle4.value = value
                        4 -> circle5.value = value
                    }
                }
            }

            for (index in 0 until 5) {
                BasicTextField(
                    value = when (index) {
                        0 -> circle1.value
                        1 -> circle2.value
                        2 -> circle3.value
                        3 -> circle4.value
                        4 -> circle5.value
                        else -> ""
                    },
                    onValueChange = { value -> onValueChange(index, value) },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 40.sp
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .then(textFieldModifier)
                        .then(singleDigitModifier)
                        .padding(start = 12.dp)
                )
            }

            LaunchedEffect(enteredPin) {
                if (enteredPin.length == 5) {
                    navController.navigate(Routes.Home.route)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage(navController = rememberNavController())
}
