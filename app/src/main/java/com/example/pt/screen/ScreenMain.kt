package com.example.pt.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.pt.Routes


@Composable
fun ScreenMain(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login.route) {

        composable(Routes.Login.route) {
            LoginPage(navController = navController)
        }

        composable(Routes.Home.route) {
            HomePage(navController = navController)
        }

        composable(Routes.Gestiondetiempo.route) {
            GestiondetiempoPage(navController = navController)
        }

        composable(Routes.Peticiontiempolibre.route){
            PeticiontiempolibrePage(navController = navController)
        }

        composable(Routes.Informacion.route){
            InformacionPage(navController = navController)
        }

        composable(Routes.Sueldo.route){
            SueldoPage(navController = navController)
        }

        composable(Routes.Ayuda.route){
            AyudaPage(navController = navController)
        }
    }
}