package com.intive.patronage22.lublin.ui.base

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:errorText")
fun TextInputLayout.setErrorMessage(errorMessage: String?) {
    this.error = errorMessage
}