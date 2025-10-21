package cl.duoc.artesaniaapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cl.duoc.artesaniaapp.ui.screens.*
import cl.duoc.artesaniaapp.viewmodel.ConfigViewModel
import cl.duoc.artesaniaapp.viewmodel.PerfilViewModel
import cl.duoc.artesaniaapp.viewmodel.ProductoViewModel

@Composable
fun AppNavHost(nav: NavHostController) {
    // ViewModels en el scope del NavGraph raíz (compartidos)
    val configVM: ConfigViewModel = viewModel()
    val perfilVM: PerfilViewModel = viewModel()
    val productoVM: ProductoViewModel = viewModel()

    NavHost(navController = nav, startDestination = Route.Home.path, route = Route.Root.path) {
        composable(Route.Home.path) {
            HomeScreen(nav, configVM)
        }
        composable(Route.Perfil.path) {
            PerfilScreen(nav, perfilVM)
        }
        composable(Route.Registrar.path) {
            RegistroScreen(nav, productoVM)
        }
        composable(Route.Resumen.path) {
            ResumenScreen(nav, productoVM)
        }
    }
}