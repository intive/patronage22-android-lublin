package com.intive.patronage22.lublin.repository.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoriesApi(
    @SerializedName("id")
    val categoryid: Int,
    @SerializedName("title")
    val categorytitle: String,
    @SerializedName("desciption")
    val categorydescription: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updratedAt: String
) : Parcelable
