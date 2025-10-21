package cl.duoc.artesaniaapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.duoc.artesaniaapp.navigation.Route
import cl.duoc.artesaniaapp.ui.components.AppScaffold
import cl.duoc.artesaniaapp.ui.components.BottomBar
import cl.duoc.artesaniaapp.viewmodel.ConfigViewModel

@Composable
fun HomeScreen(nav: NavController, vm: ConfigViewModel) {
    val modo by vm.modoVendedor.collectAsState()
    AppScaffold(nav, title = "Artesanía", bottomBar = { BottomBar(nav) }) { modifier ->
        Column(modifier.fillMaxSize().padding(16.dp)) {
            Text("Modo vendedor", style = MaterialTheme.typography.titleLarge)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(if (modo) "Activo" else "Inactivo")
                Switch(checked = modo, onCheckedChange = { vm.toggleModo() })
            }
            AnimatedVisibility(visible = modo) {
                Text("Modo vendedor activo", color = MaterialTheme.colorScheme.primary)
            }
            Spacer(Modifier.height(24.dp))
            Button(onClick = { nav.navigate(Route.Registrar.path) }) {
                Text("Registrar producto")
            }
            Spacer(Modifier.height(8.dp))
            Button(onClick = { nav.navigate(Route.Perfil.path) }) {
                Text("Ir a Perfil")
            }
        }
    }
}