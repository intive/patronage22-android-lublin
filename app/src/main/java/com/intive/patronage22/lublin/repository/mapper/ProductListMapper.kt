package com.intive.patronage22.lublin.repository.mapper

import com.intive.patronage22.lublin.repository.model.Product
import com.intive.patronage22.lublin.repository.model.ProductAPI

interface ListMapper<I, O> : Mapper<List<ProductAPI>, List<Product>>

class ProductListMapper : ListMapper<List<ProductAPI>, List<Product>> {

    override fun map(input: List<ProductAPI>): List<Product> {

        val productList: MutableList<Product> = mutableListOf()

        input.forEach {
            productList.add(Product(it.name, it.priceGross))
        }

        return productList
    }
}
