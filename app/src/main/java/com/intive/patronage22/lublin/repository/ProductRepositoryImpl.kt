package com.intive.patronage22.lublin.repository

import android.content.Context
import com.intive.patronage22.lublin.repository.mapper.ProductMapper
import com.intive.patronage22.lublin.repository.model.Product

//parametr context czy dobrze?
class ProductRepositoryImpl(var context: Context) : ProductRepository {

    override fun getProductList(): List<Product> {
        val productList: MutableList<Product> = mutableListOf()
        val jsonFetcher = JsonFetcher()
        //tutaj był mi potrebny parametr context żeby dostać się do assets
        val productAPIList = jsonFetcher.getProductAPIList(context, "products.json")
        val productMapper = ProductMapper()
        for (p in productAPIList)
            productList.add(productMapper.map(p))
        return productList
    }

}