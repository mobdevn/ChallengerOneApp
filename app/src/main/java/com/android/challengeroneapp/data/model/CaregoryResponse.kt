package com.android.challengeroneapp.data.model

import com.google.gson.annotations.SerializedName

data class CaregoryResponse(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("image")
    val image: String? = null
)