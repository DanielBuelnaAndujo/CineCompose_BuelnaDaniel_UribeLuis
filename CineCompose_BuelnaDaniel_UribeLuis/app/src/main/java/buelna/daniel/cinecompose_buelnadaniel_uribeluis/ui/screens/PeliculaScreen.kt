package buelna.daniel.cinecompose_buelnadaniel_uribeluis.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import buelna.daniel.cinecompose_buelnadaniel_uribeluis.viewmodel.PeliculaViewModel

@Composable
fun PeliculaScreen(
    viewModel: PeliculaViewModel = viewModel(),
    onClickPelicula: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Películas en cartelera",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(viewModel.peliculasDisponibles) { pelicula ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            viewModel.seleccionarPelicula(pelicula)
                            onClickPelicula()
                        },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = pelicula.nombre,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Género: ${pelicula.genero}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Costo: $${pelicula.costo}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun PeliculaScreenPreview() {
    PeliculaScreen(onClickPelicula = {})
}