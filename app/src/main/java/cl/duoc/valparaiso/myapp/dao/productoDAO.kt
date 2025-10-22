package cl.duoc.valparaiso.myapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import cl.duoc.valparaiso.myapp.data.productoData

@Dao
interface productoDAO {

    @Query("SELECT * FROM productos")
    fun getAll(): List<productoData>

    @Query("SELECT * FROM productos WHERE id IN (:idProducto)")
    fun loadAllByIds(idProducto: IntArray): List<productoData>

    @Insert
    fun insertAll(vararg producto: productoData)

    @Delete
    fun delete(producto: productoData)

}