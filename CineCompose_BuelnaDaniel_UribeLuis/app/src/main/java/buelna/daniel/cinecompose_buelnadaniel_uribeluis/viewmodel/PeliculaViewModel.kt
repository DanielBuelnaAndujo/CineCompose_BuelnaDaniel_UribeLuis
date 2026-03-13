package buelna.daniel.cinecompose_buelnadaniel_uribeluis.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import buelna.daniel.cinecompose_buelnadaniel_uribeluis.data.models.Pelicula
import kotlin.random.Random

class PeliculaViewModel : ViewModel() {

    val peliculasDisponibles = listOf(
        Pelicula("Babel", "Drama", 70.0),
        Pelicula("Son Como Niños 2", "Comedia", 70.0)
    )

    var boletoComprado by mutableStateOf(false)
        private set

    var descuento by mutableStateOf(0)
        private set

    var seleccionado by mutableStateOf<Pelicula?>(null)

    fun seleccionarPelicula(pelicula: Pelicula) {
        seleccionado = pelicula
        boletoComprado = false
        descuento = 0
    }

    fun comprarBoleto() {
        val resultado = Random.nextInt(0, 101) // 0 a 100
        if (resultado > 50) {
            boletoComprado = true
            descuento = Random.nextInt(0, 101) // 0 a 100
        } else {
            boletoComprado = false
            descuento = 0
        }
    }
}