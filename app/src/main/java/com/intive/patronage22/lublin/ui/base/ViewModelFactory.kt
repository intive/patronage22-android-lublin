package com.intive.patronage22.lublin.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.intive.patronage22.lublin.data.api.PatronageService
import com.intive.patronage22.lublin.data.repository.CategoryRepository
import com.intive.patronage22.lublin.data.repository.ProductRepository

class ViewModelFactory(private val patronageService: PatronageService) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            return ProductsViewModel(ProductRepository(patronageService)) as T
        } else if (modelClass.isAssignableFrom(CategoriesViewModel::class.java)) {
            return CategoriesViewModel(
                CategoryRepository(patronageService)) as T
        } else
            throw IllegalArgumentException("Unknown class name")
    }

}