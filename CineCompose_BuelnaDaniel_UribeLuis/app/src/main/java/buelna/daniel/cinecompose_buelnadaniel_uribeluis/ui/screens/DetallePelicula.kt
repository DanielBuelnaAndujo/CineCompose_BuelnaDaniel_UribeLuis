package buelna.daniel.cinecompose_buelnadaniel_uribeluis.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
fun DetallePelicula(
    viewModel: PeliculaViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(300.dp))

        viewModel.seleccionado?.let { pelicula ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Detalle de la película",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Nombre: ${pelicula.nombre}")
                    Text(text = "Género: ${pelicula.genero}")
                    Text(text = "Precio base: $${pelicula.costo}")

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = { viewModel.comprarBoleto() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Comprar boleto")
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    if (viewModel.intentoCompra) {
                        if (viewModel.boletoComprado) {
                            Text(
                                text = "Compra realizada",
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text(
                                text = "Descuento: ${viewModel.descuento}%"
                            )

                            if (viewModel.descuento == 100) {
                                Text(text = "¡GRATIS!")
                            } else {
                                val precioFinal = pelicula.costo - (pelicula.costo * viewModel.descuento / 100.0)
                                Text(text = "Precio final: $${"%.2f".format(precioFinal)}")
                            }
                        } else {
                            Text(
                                text = "Función agotada",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetallePeliculaPreview() {
    DetallePelicula(viewModel())
}