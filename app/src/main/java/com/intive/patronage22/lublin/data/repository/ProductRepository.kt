package com.intive.patronage22.lublin.data.repository

import com.intive.patronage22.lublin.data.api.PatronageService
import com.intive.patronage22.lublin.repository.mapper.ProductListMapper

class ProductRepository(private val patronageService: PatronageService) {

    suspend fun getAllProducts() = ProductListMapper.map(patronageService.getAllProducts())
}
