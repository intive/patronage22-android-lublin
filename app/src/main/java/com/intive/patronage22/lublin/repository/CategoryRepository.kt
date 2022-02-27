package com.intive.patronage22.lublin.repository

interface CategoryRepository {
    suspend fun getCategories(): Set<String>
}