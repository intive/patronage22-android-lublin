package com.intive.patronage22.lublin.ui.base

import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.intive.patronage22.lublin.data.repository.ProductRepository
import com.intive.patronage22.lublin.repository.model.Product
import com.intive.patronage22.lublin.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

private const val PRODUCT_EXTRA_NAME: String = "single_product_data"

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    fun getAllProducts() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = productRepository.getAllProducts()))
        } catch (exception: Exception) {
            Log.e("test", "test", exception)
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getProductFrom(intent: Intent): Product? = intent.getParcelableExtra(PRODUCT_EXTRA_NAME)

    fun pack(intent: Intent, product: Product) = intent.putExtra(PRODUCT_EXTRA_NAME, product)
}