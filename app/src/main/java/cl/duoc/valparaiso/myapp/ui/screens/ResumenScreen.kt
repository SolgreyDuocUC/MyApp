package cl.duoc.artesaniaapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.duoc.artesaniaapp.ui.components.AppScaffold
import cl.duoc.artesaniaapp.ui.components.BottomBar
import cl.duoc.artesaniaapp.ui.utils.WindowWidth
import cl.duoc.artesaniaapp.ui.utils.rememberWindowWidthClass
import cl.duoc.artesaniaapp.viewmodel.ProductoViewModel

@Composable
fun ResumenScreen(nav: NavController, vm: ProductoViewModel) {
    val ui by vm.ui.collectAsState()
    val widthClass = rememberWindowWidthClass()

    AppScaffold(nav, title = "Resumen", bottomBar = { BottomBar(nav) }) {modifier ->
        if (widthClass == WindowWidth.Compact) {
            Column(modifier.fillMaxSize().padding(16.dp)) {
                Text("Producto registrado", style = MaterialTheme.typography.titleLarge)
                Text("Nombre: ${ui.nombre}")
                Text("Precio: ${ui.precio}")
                Text("Descripción: ${ui.descripcion}")
                Text("Stock: ${ui.stock}")
            }
        } else {
            Row(modifier.fillMaxSize().padding(16.dp)) {
                Column(Modifier.weight(1f)) {
                    Text("Favoritos (mock)", style = MaterialTheme.typography.titleLarge)
                    Text("• Lana Merino")
                    Text("• Gorro tejido")
                }
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant
                )
                Column(modifier.weight(1f).padding(start = 16.dp)) {
                    Text("Resumen", style = MaterialTheme.typography.titleLarge)
                    Text("Nombre: ${ui.nombre}")
                    Text("Precio: ${ui.precio}")
                    Text("Descripción: ${ui.descripcion}")
                    Text("Stock: ${ui.stock}")
                }
            }
        }
    }
}

