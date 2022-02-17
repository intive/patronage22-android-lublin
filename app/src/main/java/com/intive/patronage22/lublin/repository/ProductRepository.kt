package com.intive.patronage22.lublin.repository

import com.intive.patronage22.lublin.repository.model.Product

interface ProductRepository {
    fun getProductList(): List<Product>
}