package com.intive.patronage22.lublin.repository

class CategoryRepositoryMock(
    private val productRepository: ProductRepository
) : CategoryRepository {

    override suspend fun getCategories(): List<String> {
        return productRepository.getProductList().map { it.category }
    }
}