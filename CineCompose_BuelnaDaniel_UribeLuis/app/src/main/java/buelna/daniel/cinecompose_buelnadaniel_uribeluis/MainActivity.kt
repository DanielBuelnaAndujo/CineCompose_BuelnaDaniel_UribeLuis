package buelna.daniel.cinecompose_buelnadaniel_uribeluis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import buelna.daniel.cinecompose_buelnadaniel_uribeluis.ui.navigation.AppNavigation
import buelna.daniel.cinecompose_buelnadaniel_uribeluis.ui.theme.CineCompose_BuelnaDaniel_UribeLuisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CineCompose_BuelnaDaniel_UribeLuisTheme {
                AppNavigation()
            }
        }
    }
}