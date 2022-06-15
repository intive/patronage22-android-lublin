package com.intive.patronage22.lublin.ui.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.intive.patronage22.lublin.data.repository.CategoryRepository
import com.intive.patronage22.lublin.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val categoryRepository: CategoryRepository
) : ViewModel() {

    fun getAllCategories() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = categoryRepository.getAllCategories()))
        } catch (exception: Exception) {
            Log.e("test", "categoryFails", exception)
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}