package cl.duoc.artesaniaapp.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.duoc.artesaniaapp.navigation.Route
import cl.duoc.artesaniaapp.ui.components.AppScaffold
import cl.duoc.artesaniaapp.ui.components.BottomBar
import cl.duoc.artesaniaapp.viewmodel.ProductoViewModel

@Composable
fun RegistroScreen(nav: NavController, vm: ProductoViewModel) {
    val ui by vm.ui.collectAsState()
    val valido = ui.errores.isEmpty() &&
            ui.nombre.isNotBlank() && ui.precio.toDoubleOrNull()?.let { it > 0 } == true &&
            ui.descripcion.length >= 10 && ui.stock.toIntOrNull()?.let { it >= 0 } == true && ui.acepta

    val btnColor by animateColorAsState(
        if (valido) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
    )

    AppScaffold(nav, title = "Registrar", bottomBar = { BottomBar(nav) }) { modifier ->
    Column(modifier
            .fillMaxSize()
            .padding(16.dp)
        ) {
            OutlinedTextField(
                value = ui.nombre, onValueChange = vm::onNombre,
                label = { Text("Nombre") }, isError = ui.errores.containsKey("nombre"),
                supportingText = { Text(ui.errores["nombre"] ?: "") }, singleLine = true
            )
            OutlinedTextField(
                value = ui.precio, onValueChange = vm::onPrecio,
                label = { Text("Precio") }, isError = ui.errores.containsKey("precio"),
                supportingText = { Text(ui.errores["precio"] ?: "") }, singleLine = true
            )
            OutlinedTextField(
                value = ui.descripcion, onValueChange = vm::onDescripcion,
                label = { Text("Descripción") }, isError = ui.errores.containsKey("descripcion"),
                supportingText = { Text(ui.errores["descripcion"] ?: "") }
            )
            OutlinedTextField(
                value = ui.stock, onValueChange = vm::onStock,
                label = { Text("Stock") }, isError = ui.errores.containsKey("stock"),
                supportingText = { Text(ui.errores["stock"] ?: "") }, singleLine = true
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = ui.acepta, onCheckedChange = vm::onAcepta)
                Text(
                    "Acepto términos y condiciones",
                    color = if (ui.errores.containsKey("acepta")) MaterialTheme.colorScheme.error else LocalContentColor.current
                )
            }

            Button(
                onClick = { if (vm.validar()) nav.navigate(Route.Resumen.path) },
                colors = ButtonDefaults.buttonColors(containerColor = btnColor)
            ) {
                Text("Guardar y ver resumen")
            }


        }
    }
}
