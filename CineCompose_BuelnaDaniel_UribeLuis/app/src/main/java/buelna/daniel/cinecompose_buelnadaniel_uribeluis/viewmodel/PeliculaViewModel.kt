package buelna.daniel.cinecompose_buelnadaniel_uribeluis.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import buelna.daniel.cinecompose_buelnadaniel_uribeluis.data.models.Pelicula
import kotlin.random.Random
import kotlin.random.nextInt

class PeliculaViewModel : ViewModel() {

    val peliculasDisponibles = listOf(
        Pelicula("Babel", "Drama", 70.0),
        Pelicula("Son Como Niños 2", "Comedia", 70.0)
    )

    var boletoComprado by mutableStateOf<Boolean>(false)
        private set

    var descuento by mutableStateOf<Int>(0)
        private set

    fun comprarBoleto() {
        val succes = (0..100).random()
        if (succes > 50) {
            boletoComprado = true
            descuento = Random.nextInt(1, 100)
        } else {
            boletoComprado = false
        }
    }
}