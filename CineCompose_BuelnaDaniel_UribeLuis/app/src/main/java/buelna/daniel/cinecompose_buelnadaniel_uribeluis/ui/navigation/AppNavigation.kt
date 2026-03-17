package buelna.daniel.cinecompose_buelnadaniel_uribeluis.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import buelna.daniel.cinecompose_buelnadaniel_uribeluis.ui.screens.DetallePelicula
import buelna.daniel.cinecompose_buelnadaniel_uribeluis.ui.screens.PeliculaScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.PELICULAS_SCREEN) {
        composable(Routes.PELICULAS_SCREEN) {
            PeliculaScreen(onClickPelicula = {navController.navigate(Routes.DETALLE_PELICULA)})
        }
        composable(Routes.DETALLE_PELICULA) {
            DetallePelicula()
        }
    }
}

object Routes {
    const val PELICULAS_SCREEN = "screen"
    const val DETALLE_PELICULA = "detail"
}