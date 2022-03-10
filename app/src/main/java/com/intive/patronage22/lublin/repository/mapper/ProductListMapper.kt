package com.intive.patronage22.lublin.repository.mapper

import com.intive.patronage22.lublin.repository.model.Product
import com.intive.patronage22.lublin.repository.model.ProductAPI

class ProductListMapper : ListMapper {

    override fun map(input: List<ProductAPI>): List<Product> {

        val productList: MutableList<Product> = mutableListOf()

        input.forEach {
            productList.add(Product(it.name, it.priceGross, it.category))
        }

        return productList
    }
}
