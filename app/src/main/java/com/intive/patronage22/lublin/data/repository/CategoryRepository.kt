package com.intive.patronage22.lublin.data.repository

class CategoryRepository(private val productRepository: ProductRepository) {
    suspend fun getAllCategories() = productRepository.getAllProducts().map { it.category }.distinct()
}