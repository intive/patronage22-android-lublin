package com.intive.patronage22.lublin.data.repository

import com.intive.patronage22.lublin.data.api.PatronageService
import com.intive.patronage22.lublin.repository.mapper.CategoryListMapper

class CategoryRepository(private val patronageService: PatronageService) {

    suspend fun getAllCategories() = CategoryListMapper.map(patronageService.getAllCategories())
}