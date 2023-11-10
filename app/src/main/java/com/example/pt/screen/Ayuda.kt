package com.example.pt.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import com.example.pt.components.CustomTopAppBar
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pt.R


@Composable
fun AyudaPage(navController: NavHostController) {

    val backgroundColor = Color(0xFFFFFFFF)

    Column(modifier = Modifier.fillMaxSize()) {
        // Column para la barra de navegación
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
        ) {
            CustomTopAppBar(
                title = "Ayuda",
                showBackIcon = true
            ) {
                navController.navigateUp()
            }
        }
        Column(
            modifier = Modifier
                .background(Color(0xFFf1f5f8))
                .padding(top = 12.dp)
                .fillMaxSize()
        ){
            Column(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .background(Color(0xFFFFFFFF))
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Descripción",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .padding(top = 8.dp)
                ) {
                    Text(
                        text = "Es una aplicación móvil de recursos humanos y nómina que ofrece soluciones integrales para la gestión de recursos humanos y el procesamiento de nóminas, la aplicación brinda herramientas para la administración de nómina, el seguimiento de tiempo y asistencia, la gestión de días libres, permite a los usuarios simplificar procesos, mejorar la eficiencia y tomar decisiones basadas en datos en el ámbito de la nómina.",
                        color = Color.Black // Texto en color blanco
                    )
                }
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0x20000000)) // Color con opacidad al 20%
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Monetización",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .padding(8.dp)
                ) {
                    Text(
                        text = "El mecanismo de monetización de la aplicación Pay Together se una estrategia clave: la Venta a Empresas a través de suscripción o licencia, esto les permite a los clientes acceder a las herramientas de la aplicación para el manejo de nómina de sus empleados.",
                        color = Color.Black // Texto en color blanco
                    )
                }
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0x20000000)) // Color con opacidad al 20%
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Responsable",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Yop: Alejandro Muñoz Vélez",
                        color = Color.Black
                    )
                    Image(
                        painter = painterResource(id = R.drawable.responsable),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 25.dp)
                            .align(Alignment.Center)
                            .size(100.dp)
                            .clip(CircleShape)
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true, backgroundColor = (0xFFf1f5f8))
@Composable
fun AyudaPagePreview() {
    AyudaPage(navController = rememberNavController())

}