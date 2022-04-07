package com.intive.patronage22.lublin.repository.mapper

import com.intive.patronage22.lublin.repository.model.GetProductResponseApi
import com.intive.patronage22.lublin.repository.model.Product

class ProductListMapper {

    companion object {
        fun map(input: List<GetProductResponseApi>): List<Product> {
            return input.map { response ->
                Product(
                    title = response.productTitle,
                    description = response.productDescription,
                    price = response.productPrice,
                    category = response.category ?: "TEST CATEGORY",
                    mainPhotoUrl = response.photosList.firstOrNull()?.url ?: ""
                )
            }
        }
    }

}