package com.intive.patronage22.lublin.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.intive.patronage22.lublin.repository.model.Product

private val gson = Gson()

class JsonFetcher {
    fun getProductAPIList(context: Context, fileName: String): List<Product> {
        val listProductAPIType = object : TypeToken<List<Product>>() {}.type
        val jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        return gson.fromJson(jsonString, listProductAPIType)
    }
}