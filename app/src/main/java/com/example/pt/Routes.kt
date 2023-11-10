package com.example.pt

sealed class Routes(val route: String) {
    object Login : Routes("Login")
    object Home: Routes("Home")
    object Gestiondetiempo: Routes("Gestiondetiempo")
    object Peticiontiempolibre: Routes("Peticiontiempolibre")
    object Informacion: Routes("Informacion")
    object Sueldo: Routes("Sueldo")
    object Ayuda: Routes("Ayuda")
}