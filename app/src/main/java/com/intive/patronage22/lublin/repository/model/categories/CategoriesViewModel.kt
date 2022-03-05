package com.intive.patronage22.lublin.repository.model.categories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intive.patronage22.lublin.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoriesViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    val categories
        get(): MutableLiveData<List<String>> {
            val result = MutableLiveData<List<String>>()
            viewModelScope.launch {
                result.postValue(
                    try {
                        categoryRepository.getCategories().distinct()
                    } catch (exception: Exception) {
                        emptyList() // TODO: handle exception
                    }
                )
            }
            return result
        }

}