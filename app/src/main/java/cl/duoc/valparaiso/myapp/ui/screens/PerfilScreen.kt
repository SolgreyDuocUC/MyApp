package cl.duoc.artesaniaapp.ui.screens

import android.content.ContentValues
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.activity.result.contract.ActivityResultContracts.TakePicture
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.duoc.artesaniaapp.ui.components.AppScaffold
import cl.duoc.artesaniaapp.ui.components.BottomBar
import cl.duoc.artesaniaapp.ui.components.ImagenPerfil
import cl.duoc.artesaniaapp.viewmodel.PerfilViewModel

@Composable
fun PerfilScreen(nav: NavController, vm: PerfilViewModel) {
    val foto by vm.foto.collectAsState()
    var cameraUri by remember { mutableStateOf<Uri?>(null) }

    val pick = rememberLauncherForActivityResult(GetContent()) { uri ->
        uri?.let { vm.setFromGallery(it) }
    }

    val takePicture = rememberLauncherForActivityResult(TakePicture()) { ok ->
        if (ok) cameraUri?.let { vm.setFromCamera(it) }
    }

    val ctx = LocalContext.current

    AppScaffold(nav, title = "Perfil", bottomBar = { BottomBar(nav) }) { modifier ->
        Column(modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            ImagenPerfil(foto)
            Spacer(Modifier.height(16.dp))
            Button(onClick = { pick.launch("image/*") }) { Text("Elegir de galería") }
            Spacer(Modifier.height(8.dp))
            Button(onClick = {
                val uri = ctx.contentResolver.insert(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    ContentValues().apply {
                        put(MediaStore.Images.Media.DISPLAY_NAME, "foto_${System.currentTimeMillis()}.jpg")
                        put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                    }
                )
                cameraUri = uri
                if (uri != null) takePicture.launch(uri)
            }) { Text("Tomar foto") }
        }
    }
}
