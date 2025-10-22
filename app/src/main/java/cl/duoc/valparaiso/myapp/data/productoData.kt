package cl.duoc.valparaiso.myapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Productos")
class productoData (

    @PrimaryKey(autoGenerate = true)        val id: Int = 1,
    @ColumnInfo (name = "nombre")           val nombre: String = "",
    @ColumnInfo (name = "precio")           val precio: String = "",
    @ColumnInfo (name = "descripcion")      val descripcion: String = "",
    @ColumnInfo (name = "stock")            val stock: String = "",
    @ColumnInfo (name = "acepta")           val acepta: Boolean = false,
    @ColumnInfo (name = "errores")          val errores: Map<String, String> = emptyMap()

)