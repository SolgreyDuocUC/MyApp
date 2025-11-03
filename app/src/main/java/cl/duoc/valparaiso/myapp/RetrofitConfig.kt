package cl.duoc.valparaiso.myapp

import cl.duoc.valparaiso.myapp.data.productDataService
import cl.duoc.valparaiso.myapp.service.productService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl("https://api.v1.tu.artesania.cl/")
            .addConverterFactory(GsonConverterFactory.create()) // OmoshiConverterFactory
            .build()

    /*
    val apiService: com.google.firebase.appdistribution.gradle.ApiService
        get() = retrofit.create(com.google.firebase.appdistribution.gradle.ApiService::class.java)

    val productService = retrofit.create<productService>("https://api.v1.tu.artesania.cl/product")
    */
}