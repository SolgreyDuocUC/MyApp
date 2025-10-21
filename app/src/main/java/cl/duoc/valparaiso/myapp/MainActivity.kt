package cl.duoc.valparaiso.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import cl.duoc.artesaniaapp.navigation.AppNavHost
import cl.duoc.artesaniaapp.ui.theme.ArtesaniaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // opcional
        setContent {
            ArtesaniaAppTheme {
                val navController = rememberNavController()
                AppNavHost(navController)
            }
        }
    }
}