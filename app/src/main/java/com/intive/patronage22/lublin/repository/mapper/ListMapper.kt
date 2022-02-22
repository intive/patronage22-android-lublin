package com.intive.patronage22.lublin.repository.mapper

import com.intive.patronage22.lublin.repository.model.Product
import com.intive.patronage22.lublin.repository.model.ProductAPI

interface ListMapper {
    fun map(input: List<ProductAPI>): List<Product>
}