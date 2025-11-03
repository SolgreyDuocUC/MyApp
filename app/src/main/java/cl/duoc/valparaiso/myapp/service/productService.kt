package cl.duoc.valparaiso.myapp.service

import cl.duoc.valparaiso.myapp.data.productDataService
import retrofit2.http.GET

public interface productService {
    @GET("Productos")
    suspend fun getProductos():List<productDataService>
}