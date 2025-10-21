package cl.duoc.artesaniaapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    nav: NavController,
    title: String,
    bottomBar: @Composable () -> Unit = {},
    content: @Composable (Modifier) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) },
                colors = TopAppBarDefaults.topAppBarColors(
                    // Color de fondo del TopAppBar
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    // Color del texto del título
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        bottomBar = bottomBar,
        contentWindowInsets = WindowInsets.safeDrawing
    ) { innerPadding ->
        content(Modifier.padding(innerPadding))
    }
}