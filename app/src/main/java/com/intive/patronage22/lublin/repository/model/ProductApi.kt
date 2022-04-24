package com.intive.patronage22.lublin.repository.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductApi(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val productTitle: String,
    @SerializedName("price")
    val productPrice: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("description")
    val productDescription: String,
    @SerializedName("published")
    val isPublished: Boolean,
    @SerializedName("createdAt")
    val createAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("photos")
    val photosList: List<PhotoApi>,
    @SerializedName("category")
    val category: String?,
    @SerializedName("categoryId")
    val categoryId: Int
) : Parcelable
@Parcelize
data class PhotoApi(
    @SerializedName("id")
    val photoId: Int,
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("active")
    val isActive: Boolean,
    @SerializedName("main_photo")
    val isMainPhoto: Boolean,
    @SerializedName("createdAt")
    val photoCreateAt: String,
    @SerializedName("updatedAt")
    val photoUpdatedAt: String
) : Parcelable