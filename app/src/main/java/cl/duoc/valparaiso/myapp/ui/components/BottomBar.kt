package cl.duoc.artesaniaapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import cl.duoc.artesaniaapp.navigation.Route

@Composable
fun BottomBar(nav: NavController) {
    NavigationBar {
        NavigationBarItem(
            selected = false, onClick = { nav.navigate(Route.Home.path) },
            label = { Text("Home") }, icon = { Icon(Icons.Filled.Home, null) }
        )
        NavigationBarItem(
            selected = false, onClick = { nav.navigate(Route.Registrar.path) },
            label = { Text("Registrar") }, icon = { Icon(Icons.Filled.Add, null) }
        )
        NavigationBarItem(
            selected = false, onClick = { nav.navigate(Route.Perfil.path) },
            label = { Text("Perfil") }, icon = { Icon(Icons.Filled.Person, null) }
        )
    }
}