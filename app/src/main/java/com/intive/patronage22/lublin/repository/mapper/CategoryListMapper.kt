package com.intive.patronage22.lublin.repository.mapper

import com.intive.patronage22.lublin.repository.model.CategoriesApi
import com.intive.patronage22.lublin.repository.model.Category
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryListMapper @Inject constructor() {

    fun map(input: List<CategoriesApi>): List<Category> {
        return input.map { response ->
            Category(
                title = response.categorytitle
            )
        }
    }
}