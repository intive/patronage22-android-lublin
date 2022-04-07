package com.intive.patronage22.lublin.repository.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val title: String,
    val description: String,
    val price: Int,
    val category: String,
    val mainPhotoUrl:String
) : Parcelable