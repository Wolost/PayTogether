package com.example.pt.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pt.R
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pt.Routes

@Composable
fun HomePage(navController: NavHostController) {


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            //-------------------Columna 1: Imagen y texto-------------------
            val backgroundColor = Color(0xFFb5b5b3)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(backgroundColor)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "Bienvenido USER",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }

        item {
            //-------------------Columna 2: Opciones de gestión de tiempo, petición de tiempo libre, información y sueldo-------------------
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                val options = listOf(
                    "Gestion de tiempo" to Icons.Default.Check,
                    "Petición de Tiempo libre" to Icons.Default.DateRange,
                    "Información" to Icons.Default.Info,
                    "Sueldo" to Icons.Default.Star
                )

                OptionList(options = options, navController = navController)
            }
            //-------------------Separador-------------------
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color(0x20000000)) // Color con opacidad al 20%
            )
        }

        item {
            //-------------------Columna 3: Opciones de configuración, ayuda y feedback-------------------
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                val options = listOf(
                    "Configuracion" to Icons.Default.Settings,
                    "Ayuda" to Icons.Default.MoreVert,
                    "Feedback" to Icons.Default.Email
                )

                OptionList(options = options, navController = navController)
            }
        }
    }
}

@Composable
fun OptionList(options: List<Pair<String, ImageVector>>, navController: NavHostController) {
    options.forEach { (text, icon) ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    when (text) {
                        "Gestion de tiempo" -> {
                            navController.navigate(Routes.Gestiondetiempo.route)
                        }
                        "Petición de Tiempo libre" -> {
                            navController.navigate(Routes.Peticiontiempolibre.route)
                        }
                        "Información" -> {
                            navController.navigate(Routes.Informacion.route)
                        }
                        "Sueldo" -> {
                            navController.navigate(Routes.Sueldo.route)
                        }
                        "Configuracion" -> {
                            //navController.navigate(Routes.Configuracion.route)
                        }
                        "Ayuda" -> {
                            navController.navigate(Routes.Ayuda.route)
                        }
                        "Feedback" -> {
                            //navController.navigate(Routes.Feedback.route)
                        }
                        else -> {
                        }
                    }
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = text, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    HomePage(navController = rememberNavController())
}
