package cl.duoc.valparaiso.myapp.bases

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.duoc.artesaniaapp.model.ProductoUiState
import cl.duoc.valparaiso.myapp.dao.productoDAO

class AppDataBases {

    @Database(entities = [ProductoUiState::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun productoDao(): productoDAO
    }

}