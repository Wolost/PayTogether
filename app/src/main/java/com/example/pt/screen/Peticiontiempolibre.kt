package com.example.pt.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mabn.calendarlibrary.ExpandableCalendar
import com.mabn.calendarlibrary.core.calendarDefaultTheme
import java.time.LocalDate
import com.example.pt.components.CustomTopAppBar


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PeticiontiempolibrePage(navController: NavHostController) {

    val backgroundColor = Color(0xFFf1f5f8)
    val currentDate = remember { mutableStateOf(LocalDate.now()) }

    Column(modifier = Modifier.fillMaxSize()) {
        // Column para la barra de navegación
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
        ) {
            CustomTopAppBar(
                title = "Petición de Tiempo Libre",
                showBackIcon = true
            ) {
                navController.navigateUp()
            }
        }

        // Column para el calendario
        Column(
            modifier = Modifier
                .weight(1f)
                .background(backgroundColor)
        ) {
            Calendar(currentDate = currentDate)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Calendar(currentDate: MutableState<LocalDate>) {
    val scrollState = rememberScrollState()
    ExpandableCalendar(
        theme = calendarDefaultTheme.copy(
            dayShape = CircleShape,
            backgroundColor = Color.White,
            selectedDayBackgroundColor = Color(0xFFf1f5f8),
            dayValueTextColor = Color.Black,
            selectedDayValueTextColor = Color.Black,
            headerTextColor = Color.Black,
            weekDaysTextColor = Color.Black
        ),
        onDayClick = {
            currentDate.value = it
        }
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFf1f5f8)) // Fondo blanco detrás del calendario
    ) {
        Text("Selected date: ${currentDate.value}")
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, backgroundColor = (0xFFf1f5f8))
@Composable
fun PeticiontiempolibrePagePreview() {
    PeticiontiempolibrePage(navController = rememberNavController())

}