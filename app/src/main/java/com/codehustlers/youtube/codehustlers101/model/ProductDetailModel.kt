package com.codehustlers.youtube.codehustlers101.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductDetailModel(var productName: String, var productPrice: String, var isFav: Boolean = false) : Parcelable