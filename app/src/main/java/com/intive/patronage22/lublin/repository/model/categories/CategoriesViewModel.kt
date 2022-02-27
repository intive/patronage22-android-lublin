package com.intive.patronage22.lublin.repository.model.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intive.patronage22.lublin.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoriesViewModel(categoryRepository: CategoryRepository) : ViewModel() {
   lateinit var categories: Set<String>

    init {
        viewModelScope.launch {
            categories = categoryRepository.getCategories()
        }
    }
}