package com.intive.patronage22.lublin.repository.model.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intive.patronage22.lublin.repository.ProductRepository
import com.intive.patronage22.lublin.repository.model.Product
import kotlinx.coroutines.launch

class HomeViewModel(private val productRepository: ProductRepository) : ViewModel()  {

    val products
        get(): LiveData<List<Product>> {
            val result = MutableLiveData<List<Product>>()
            viewModelScope.launch {
                result.postValue(
                    try {
                        productRepository.getProductList()
                    } catch (exception: Exception) {
                        emptyList() // TODO: handle exception
                    }
                )
            }
            return result
        }

}