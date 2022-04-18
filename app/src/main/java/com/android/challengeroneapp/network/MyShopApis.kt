package com.android.challengeroneapp.network

import com.android.challengeroneapp.data.model.CaregoryResponse
import com.android.challengeroneapp.data.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyShopApis {

    @GET("/products")
    fun getAllProducts(): Call<List<ProductResponse>>

    @GET("/products/{id}")
    fun getProductDetails(@Query("id") id: String): Call<ProductResponse>

    @GET("/products/categories")
    fun getAllCategories(): Call<List<CaregoryResponse>>

    @GET("/products/category/{category}")
    fun getCategoryProducts(category: String): Call<List<ProductResponse>>
}