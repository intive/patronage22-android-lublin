package com.intive.patronage22.lublin.repository

import android.content.Context
import com.intive.patronage22.lublin.repository.mapper.ProductListMapper
import com.intive.patronage22.lublin.repository.model.Product

class ProductRepositoryImpl(var context: Context) : ProductRepository {

    override fun getProductList(): List<Product> {
        val jsonFetcher = JsonFetcher()
        val productAPIList = jsonFetcher.getProductAPIList(context, "products.json")
        val productMapper = ProductListMapper()

        return productMapper.map(productAPIList)
    }
}