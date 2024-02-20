package com.example.manejodecard.ui.theme.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Platillo(
    @StringRes val stringResourceId: Int,
    @DrawableRes val drawableResourceId: Int,
    val d: Double,
    val b: Boolean,
    val precio: Double
)