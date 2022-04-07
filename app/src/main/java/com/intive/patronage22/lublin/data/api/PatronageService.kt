package com.intive.patronage22.lublin.data.api

import com.intive.patronage22.lublin.repository.model.GetProductResponseApi
import com.intive.patronage22.lublin.repository.model.Product
import retrofit2.http.GET


interface PatronageService {
    @GET("products/getAllProductsExternal")
    suspend fun getAllProducts(): List<GetProductResponseApi>
}