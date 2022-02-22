package com.intive.patronage22.lublin.repository.model

import com.google.gson.annotations.SerializedName

data class ProductAPI(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("priceGross")
    val priceGross: Double,
    @SerializedName("tax")
    val tax: Double,
    @SerializedName("keywords")
    val keywords: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("imageUrl")
    val imageUrl: String
)