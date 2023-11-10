package com.example.pt.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.pt.components.AnimatedCircle
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.LinearProgressIndicator
import com.example.pt.components.CustomTopAppBar


@Composable
fun GestiondetiempoPage(navController: NavHostController) {

    val backgroundColor = Color(0xFFFFFFFF)

    val circleColor = Color(0xFF33AAFE)
    val circleProportion = 0.75f //
    val totalHoras = 5
    val totalDias = 17


    var selectedMonth by remember { mutableStateOf("Enero") }
    var selectedOption by remember { mutableStateOf("Horas") }

    val months = listOf("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")
    val options = listOf("Horas", "Días")

    var monthMenuExpanded by remember { mutableStateOf(false) }
    var optionMenuExpanded by remember { mutableStateOf(false) }

   Column( modifier = Modifier.fillMaxSize()) {
       Column(
           modifier = Modifier
               .fillMaxSize()
               .weight(1f)
               .background(backgroundColor)
       ) {
           CustomTopAppBar(
               title = "Gestión de Tiempo",
               showBackIcon = true
           ) {
               navController.navigateUp()
           }
           // Animated Circle
           Box(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(150.dp)
           ) {
               AnimatedCircle(
                   proportions = listOf(circleProportion),
                   colors = listOf(circleColor),
                   modifier = Modifier.fillMaxSize()
               )
               Text(
                   text = "        5 \n Horas hoy",
                   style = TextStyle(fontSize = 20.sp,
                       fontWeight = FontWeight.Bold
                   ),
                   modifier = Modifier
                       .align(Alignment.Center)
                       .paddingFromBaseline(top = 0.dp)
               )
               Text(
                   text = "Tu turno es 8 horas",
                   style = TextStyle(fontSize = 12.sp),
                   modifier = Modifier
                       .align(Alignment.Center)
                       .paddingFromBaseline(top = 70.dp)
               )
           }
           Spacer(modifier = Modifier.height(16.dp))

           // Linea con opacidad
           Spacer(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(1.dp)
                   .background(Color(0x33000000)) // Opacity 20%
           )

           Spacer(modifier = Modifier.height(16.dp))

           // Función para formatear horas en HH:MM:SS
           fun formatHoursToHHMMSS(hours: Int): String {
               val hoursPart = hours / 3600
               val minutesPart = (hours % 3600) / 60
               val secondsPart = hours % 60
               return String.format("%02d:%02d:%02d", hoursPart, minutesPart, secondsPart)
           }

           // Table
           val tableData = listOf(
               TableRowData("Total Horas", "Total Tiempo", "Total Días"),
               TableRowData("$totalHoras H", formatHoursToHHMMSS(491227), "$totalDias D")
           )
           SimpleTable(tableData)
       }
       Column (
           modifier = Modifier
               .fillMaxSize()
               .weight(1f)
               .background(backgroundColor))
       {
           // SEGMENTO DE LOS DROPDOWN
           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .border(0.dp, Color(0x33000000), shape = RoundedCornerShape(0, 0, 0, 0))
                   .padding(top = 8.dp, bottom = 8.dp)
           ) {
               // Meses Dropdown
               Box(
                   modifier = Modifier
                       .weight(1f)
                       .border(0.dp, Color(0x33000000), shape = RoundedCornerShape(0, 0, 0, 0))
                       .background(Color.White)
                       .clickable { monthMenuExpanded = true }
               ) {
                   Text(
                       text = selectedMonth,
                       modifier = Modifier
                           .padding(16.dp)
                   )
                   Icon(
                       imageVector = Icons.Default.ArrowDropDown,
                       contentDescription = "Expand",
                       modifier = Modifier
                           .align(Alignment.CenterEnd)
                           .padding(end = 16.dp)
                   )
               }

               DropdownMenu(
                   expanded = monthMenuExpanded,
                   onDismissRequest = { monthMenuExpanded = false },
                   modifier = Modifier.background(Color.White)
               ) {
                   months.forEach { month ->
                       DropdownMenuItem(onClick = {
                           selectedMonth = month
                           monthMenuExpanded = false
                       }) {
                           Text(text = month)
                       }
                   }
               }

               Spacer(modifier = Modifier
                   .width(1.dp)
                   .background(Color(0x33000000)))

               // Opciones Dropdown
               Box(
                   modifier = Modifier
                       .weight(1f)
                       .border(0.dp, Color(0x33000000), shape = RoundedCornerShape(0, 0, 0, 0))
                       .background(Color.White)
                       .clickable { optionMenuExpanded = true }
               ) {
                   Text(
                       text = selectedOption,
                       modifier = Modifier
                           .padding(16.dp)
                   )
                   Icon(
                       imageVector = Icons.Default.ArrowDropDown,
                       contentDescription = "Expand",
                       modifier = Modifier
                           .align(Alignment.CenterEnd)
                           .padding(end = 16.dp)
                   )
               }

               DropdownMenu(
                   expanded = optionMenuExpanded,
                   onDismissRequest = { optionMenuExpanded = false },
                   modifier = Modifier.background(Color.White)
               ) {
                   options.forEach { option ->
                       DropdownMenuItem(onClick = {
                           selectedOption = option
                           optionMenuExpanded = false
                       }) {
                           Text(text = option)
                       }
                   }
               }
           }
           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(16.dp)
           ) {
               // Nombre del mes
               Text(
                   text = "Febrero",
                   style = TextStyle(fontSize = 20.sp,
                       fontWeight = FontWeight.Bold
                   ),
                   modifier = Modifier
                       .paddingFromBaseline(top = 0.dp)
               )

               Text(
                   text = "18 D",
                   style = TextStyle(fontSize = 18.sp, textAlign = TextAlign.End),
                   modifier = Modifier.fillMaxWidth()

               )

           }
           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(16.dp)
           ) {
               // Barra de carga al 70%
               LinearProgressIndicator(
                   progress = 0.7f,
                   color = Color(0xFF33AAFE),
                   modifier = Modifier
                       .height(12.dp)
                       .weight(4f)
                       .padding(end = 2.dp)
               )

               Spacer(modifier = Modifier
                   .width(0.dp)
                   .weight(1f))

               Text(
                   text = "144 H",
                   style = TextStyle(fontSize = 18.sp, textAlign = TextAlign.End),
                   modifier = Modifier.offset(y = (-10).dp) // Ajuste vertical para subir el texto
               )
           }
           // Linea con opacidad
           Spacer(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(1.dp)
                   .background(Color(0x33000000)) // Opacity 20%
           )

           // Segunda fila (Enero)
           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(16.dp)
           ) {
               // Nombre del mes
               Text(
                   text = "Enero",
                   style = TextStyle(fontSize = 20.sp,
                       fontWeight = FontWeight.Bold
                   ),
                   modifier = Modifier
                       .paddingFromBaseline(top = 0.dp)
               )

               Text(
                   text = "6 D",
                   style = TextStyle(fontSize = 18.sp, textAlign = TextAlign.End),
                   modifier = Modifier.fillMaxWidth()

               )

           }
           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(16.dp)
           ) {
               // Barra de carga al 20%
               LinearProgressIndicator(
                   progress = 0.2f,
                   color = Color(0xFF33AAFE),
                   modifier = Modifier
                       .height(12.dp)
                       .weight(4f)
                       .padding(end = 2.dp)
               )

               Spacer(modifier = Modifier
                   .width(0.dp)
                   .weight(1f))

               Text(
                   text = "48 H",
                   style = TextStyle(fontSize = 18.sp, textAlign = TextAlign.End),
                   modifier = Modifier.offset(y = (-10).dp)
               )
           }
           Spacer(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(1.dp)
                   .background(Color(0x33000000)) // Opacity 20%
           )
       }

   }



}

@Composable
fun SimpleTable(data: List<TableRowData>) {
    Column {
        data.forEachIndexed { index, rowData ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (index == 0) {
                    // Configuración para la primera fila
                    Text(
                        text = rowData.column1,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = rowData.column2,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = rowData.column3,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                } else {
                    // Configuración para las filas restantes
                    Text(
                        text = rowData.column1,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 25.dp)
                    )
                    Text(
                        text = rowData.column2,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = rowData.column3,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end = 20.dp)
                    )
                }
            }
        }
    }
}

data class TableRowData(val column1: String, val column2: String, val column3: String)

@Preview(showBackground = true, backgroundColor = (0xFFf1f5f8))
@Composable
fun GestiondetiempoPagePreview() {
    GestiondetiempoPage(navController = rememberNavController())

}