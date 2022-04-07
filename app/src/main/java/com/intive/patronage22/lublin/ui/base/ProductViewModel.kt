package com.intive.patronage22.lublin.ui.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.intive.patronage22.lublin.data.repository.ProductRepository
import com.intive.patronage22.lublin.utils.Resource
import kotlinx.coroutines.Dispatchers

class ProductViewModel(private val productRepository: ProductRepository) : ViewModel() {

    fun getAllProducts() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = productRepository.getAllProducts()))
        } catch (exception: Exception) {
            Log.e("test", "test", exception)
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}