package com.intive.patronage22.lublin.data.repository

import com.intive.patronage22.lublin.data.api.PatronageService
import com.intive.patronage22.lublin.repository.mapper.CategoryListMapper
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val patronageService: PatronageService,
    private val categoryListMapper: CategoryListMapper
) {

    suspend fun getAllCategories() = categoryListMapper.map(patronageService.getAllCategories())
}