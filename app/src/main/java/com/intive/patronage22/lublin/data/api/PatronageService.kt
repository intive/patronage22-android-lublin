package com.intive.patronage22.lublin.data.api

import com.intive.patronage22.lublin.repository.model.ProductApi
import retrofit2.http.GET


interface PatronageService {
    @GET("products/getAllPublishedProductsExternal")
    suspend fun getAllProducts(): List<ProductApi>
}