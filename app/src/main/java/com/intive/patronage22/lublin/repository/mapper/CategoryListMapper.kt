package com.intive.patronage22.lublin.repository.mapper

import com.intive.patronage22.lublin.repository.model.CategoriesApi
import com.intive.patronage22.lublin.repository.model.Category

class CategoryListMapper {
    companion object {
        fun map(input: List<CategoriesApi>): List<Category> {
            return input.map { response ->
                Category(
                    title = response.categorytitle
                )
            }
        }
    }
}