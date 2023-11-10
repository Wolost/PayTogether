package com.example.pt.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pt.components.CustomTopAppBar

@Composable
fun SueldoPage(navController: NavHostController) {

    val backgroundColor = Color(0xFFFFFFFF)

    Column(modifier = Modifier.fillMaxSize()) {
        // Column para la barra de navegación
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
        ) {
            CustomTopAppBar(
                title = "Sueldo",
                showBackIcon = true
            ) {
                navController.navigateUp()
            }
        }

        // Establece los pesos de las columnas
        val weightTopColumn = 3f
        val weightBottomColumn = 6f

// Columna superior
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(weightTopColumn)
                .height(10.dp)
                .padding(16.dp)
                .background(backgroundColor)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Envuelve la Columna en un Box para centrar horizontalmente
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                ) {
                    Text(
                        text = "Tu ingreso este mes",
                        color = Color(0x80000000),
                        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 20.dp)
                    )
                    Text(
                        text = "$941.000,00",
                        style = TextStyle(fontSize = 35.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                    Text(
                        text = "COP",
                        style = TextStyle(fontSize = 14.sp),
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 20.dp)
                    )
                }
            }
        }

// Columna inferior
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(weightBottomColumn)
                .height(10.dp)
                .padding(16.dp)
        ) {
            // Primera columna del 10%
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.1f)
            ) {
                // Contenido de la primera columna aquí
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    repeat(5) { index ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp) // Ajusta la altura según tus necesidades
                        ) {

                            val circleModifier = if (index == 1 || index == 2 || index == 4) {
                                Modifier
                                    .size(16.dp)
                                    .background(Color(0xFF33AAFE), CircleShape)
                            } else {
                                Modifier
                                    .size(16.dp)
                                    .background(Color(0x33000000), CircleShape)
                            }

                            Box(modifier = circleModifier)
                        }

                        if (index < 4) {
                            Spacer(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .background(Color(0x33000000))
                            )
                        }
                    }

                }
            }

            // Segunda columna del 80%
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.8f)
            ) {
                // Contenido de la segunda columna aquí
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    val textList = listOf("Recolecta", "Desconocido", "Horas Extra", "Multa", "Pago Nómina")
                    val textList2 = listOf("Hoy 5:30 P.M", "Ayer 8:54 P.M", "18 Feb 5:31 P.M", "18/Feb 5:30 P.M", "1/Feb 12:00 ")

                    textList.forEachIndexed { index, text ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp) // Ajusta la altura según tus necesidades
                        ) {
                            Text(text = text,
                                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(start = 25.dp))
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp) // Ajusta la altura según tus necesidades

                        ){
                            Text(text = textList2[index],
                                style = TextStyle(fontSize = 14.sp),
                                color = Color(0x80000000),
                                modifier = Modifier.padding(start = 25.dp))
                        }

                        if (index < textList.size - 1) {
                            Spacer(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .background(Color(0x33000000))
                            )
                        }
                    }
                }
            }


            // Tercera columna del 10%
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.34f)
                    .align(Companion.CenterEnd)

            ) {
                // Contenido de la tercera columna aquí
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    val textList = listOf("- $9.000,00", "+ $5.000,00", "+ $25.000,00", "- $30.000", "+$950.000,00")

                    textList.forEachIndexed { index, text ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp) // Ajusta la altura según tus necesidades
                        ) {
                            val textColor = if (index == 1 || index == 2 || index == 4) {
                                Color(0xFF33AAFE)
                            } else {
                                Color.Black
                            }
                            Text(text = text,
                                color = textColor,
                                style = TextStyle(fontSize = 16.sp, textAlign = TextAlign.End),
                                modifier = Modifier
                                    .padding(start = 20.dp))
                        }

                        if (index < textList.size - 1) {
                            Spacer(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .background(Color(0x33000000))
                            )
                        }
                    }
                }
            }
        }

    }
}



@Preview(showBackground = true, backgroundColor = (0xFFf1f5f8))
@Composable
fun SueldoPagePreview() {
    SueldoPage(navController = rememberNavController())

}