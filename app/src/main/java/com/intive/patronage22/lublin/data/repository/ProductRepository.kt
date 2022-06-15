package com.intive.patronage22.lublin.data.repository

import com.intive.patronage22.lublin.data.api.PatronageService
import com.intive.patronage22.lublin.repository.mapper.ProductListMapper
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val patronageService: PatronageService,
    private val productListMapper: ProductListMapper
) {

    suspend fun getAllProducts() = productListMapper.map(patronageService.getAllProducts())
}
