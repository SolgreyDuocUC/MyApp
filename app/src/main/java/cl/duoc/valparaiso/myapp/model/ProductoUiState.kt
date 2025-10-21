package cl.duoc.artesaniaapp.model

data class ProductoUiState(
    val nombre: String = "",
    val precio: String = "",
    val descripcion: String = "",
    val stock: String = "",
    val acepta: Boolean = false,
    val errores: Map<String, String> = emptyMap()
)