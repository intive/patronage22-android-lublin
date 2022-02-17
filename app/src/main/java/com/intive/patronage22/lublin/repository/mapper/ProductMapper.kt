package com.intive.patronage22.lublin.repository.mapper

import com.intive.patronage22.lublin.repository.model.Product
import com.intive.patronage22.lublin.repository.model.ProductAPI

class ProductMapper : Mapper<ProductAPI, Product> {
    override fun map(input: ProductAPI): Product {
        return Product(input.name, input.priceGross)
    }
}