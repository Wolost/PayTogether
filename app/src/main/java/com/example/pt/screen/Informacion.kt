package com.example.pt.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.pt.components.CustomTopAppBar

@Composable
fun InformacionPage(navController: NavHostController) {
    val backgroundColor = Color(0xFFFFFFFF)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFf1f5f8))
    ) {
        // Columna para la barra de navegación
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
        ) {
            CustomTopAppBar(
                title = "Información",
                showBackIcon = true
            ) {
                navController.navigateUp()
            }
        }

        // Columna para la imagen, nombre de usuario y ubicación
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen de usuario
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Texto en negrilla "USER"
            Text(
                text = "USER",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Texto con ícono de ubicación y "Popayán, CAU"
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "Location",
                    tint = Color(0x33000000)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Popayán, CAUCA",
                    color = Color(0x33000000),
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))


            // Table
            val tableData = listOf(
                TableRowData("      días \n trabajados", "Balance", "Gastado"),
                TableRowData("17", "\$941.000", "\$-39.000"),

            )
            SimpleTable(tableData)
        }
        Spacer(modifier = Modifier.height(25.dp))
        // Columna para la cuenta de usuario
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(8.dp)
        ) {
            Text(
                text = "CUENTA DE BANCO",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            // Fila con ícono de billetera, texto "CUENTA USER" y número en negrilla
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(100.dp)
                    .background(Color.White),
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Cuenta",
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.CenterVertically)

                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(3f)

                ) {
                    Text(
                        text = "CUENTA USER",
                        color = Color(0x33000000),
                        fontSize = 16.sp
                    )
                    Text(
                        text = "012345678",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Enviar",
                    tint = Color(0x33000000),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            // Fila con ícono de tarjeta, texto "TARJETA USER" y número en negrilla
            Text(
                text = "TARJETAS",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Row(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.White),
                verticalAlignment = Alignment.Bottom
            ) {
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = "Tarjeta",
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .weight(3f)
                ) {
                    Text(
                        text = "VISA",
                        color = Color(0x33000000),
                        fontSize = 16.sp
                    )
                    Text(
                        text = "1234-XXXX 11/30 111",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Nombre Usuario",
                        color = Color(0x33000000),
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Enviar",
                    tint = Color(0x33000000),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}



@Composable
@Preview(showBackground = true)
fun InformacionPagePreview() {
    InformacionPage(navController = rememberNavController())
}
