package com.intive.patronage22.lublin.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.intive.patronage22.lublin.repository.model.ProductAPI

private val gson = Gson()

class JsonFetcher {
    fun getProductAPIList(context: Context, fileName: String): List<ProductAPI> {
        val listProductAPIType = object : TypeToken<List<ProductAPI>>() {}.type
        val jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        return gson.fromJson(jsonString, listProductAPIType)
    }
}