package buelna.daniel.cinecompose_buelnadaniel_uribeluis.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import buelna.daniel.cinecompose_buelnadaniel_uribeluis.ui.screens.DetallePeliculaScreen
import buelna.daniel.cinecompose_buelnadaniel_uribeluis.ui.screens.PeliculaScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "peliculas") {
        composable(route = "peliculas") {
            PeliculaScreen()
        }
        composable(route = "detalle") {
            DetallePeliculaScreen()
        }
    }
}