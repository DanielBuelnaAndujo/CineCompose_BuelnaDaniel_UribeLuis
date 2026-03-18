package buelna.daniel.cinecompose_buelnadaniel_uribeluis.ui.navigation

import android.telecom.Call
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import buelna.daniel.cinecompose_buelnadaniel_uribeluis.ui.screens.DetallePelicula
import buelna.daniel.cinecompose_buelnadaniel_uribeluis.ui.screens.PeliculaScreen
import buelna.daniel.cinecompose_buelnadaniel_uribeluis.viewmodel.PeliculaViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val peliculaViewModel: PeliculaViewModel = remember { PeliculaViewModel() }
    NavHost(navController = navController, startDestination = Routes.PELICULAS_SCREEN) {
        composable(Routes.PELICULAS_SCREEN) {
            PeliculaScreen(onClickPelicula = {navController.navigate(Routes.DETALLE_PELICULA)}, viewModel = peliculaViewModel)
        }
        composable(Routes.DETALLE_PELICULA) {
            DetallePelicula(peliculaViewModel)
        }
    }
}

object Routes {
    const val PELICULAS_SCREEN = "screen"
    const val DETALLE_PELICULA = "detail"
}