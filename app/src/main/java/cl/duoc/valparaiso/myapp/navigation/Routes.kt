package cl.duoc.artesaniaapp.navigation
sealed class Route(val path: String) {
    data object Root : Route("root")
    data object Home : Route("home")
    data object Perfil : Route("perfil")
    data object Registrar : Route("registrar")
    data object Resumen : Route("resumen")
}
