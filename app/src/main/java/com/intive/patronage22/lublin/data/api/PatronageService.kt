package com.intive.patronage22.lublin.data.api

import com.intive.patronage22.lublin.repository.model.CategoriesApi
import com.intive.patronage22.lublin.repository.model.ProductApi
import com.intive.patronage22.lublin.repository.model.registration.RegisterResponseBody
import com.intive.patronage22.lublin.repository.model.registration.RegisterUserBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PatronageService {
    @GET("products/getAllPublishedProductsExternal")
    suspend fun getAllProducts(): List<ProductApi>

    @GET("categories")
    suspend fun getAllCategories(): List<CategoriesApi>

    @POST("auth/register")
    suspend fun registerUser(
        @Body registerUserBody: RegisterUserBody
    ): Response<RegisterResponseBody>
}