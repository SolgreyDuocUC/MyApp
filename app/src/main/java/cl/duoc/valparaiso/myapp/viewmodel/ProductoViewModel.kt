package cl.duoc.artesaniaapp.viewmodel

import androidx.lifecycle.ViewModel
import cl.duoc.artesaniaapp.model.ProductoUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductoViewModel : ViewModel() {
    private val _ui = MutableStateFlow(ProductoUiState())
    val ui = _ui.asStateFlow()

    fun onNombre(s: String) = _ui.update { it.copy(nombre = s) }
    fun onPrecio(s: String) = _ui.update { it.copy(precio = s) }
    fun onDescripcion(s: String) = _ui.update { it.copy(descripcion = s) }
    fun onStock(s: String) = _ui.update { it.copy(stock = s) }
    fun onAcepta(b: Boolean) = _ui.update { it.copy(acepta = b) }

    fun validar(): Boolean {
        val errs = mutableMapOf<String, String>()
        if (ui.value.nombre.isBlank()) errs["nombre"] = "Requerido"
        val precio = ui.value.precio.toDoubleOrNull()
        if (precio == null || precio <= 0) errs["precio"] = "Debe ser > 0"
        if (ui.value.descripcion.length < 10) errs["descripcion"] = "Mínimo 10 caracteres"
        val stock = ui.value.stock.toIntOrNull()
        if (stock == null || stock < 0) errs["stock"] = "Entero ≥ 0"
        if (!ui.value.acepta) errs["acepta"] = "Debes aceptar condiciones"

        _ui.value = ui.value.copy(errores = errs)
        return errs.isEmpty()
    }
}

private inline fun <T> MutableStateFlow<T>.update(transform: (T) -> T) {
    value = transform(value)
}