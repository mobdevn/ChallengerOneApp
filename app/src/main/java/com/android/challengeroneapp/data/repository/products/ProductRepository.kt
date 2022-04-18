package com.android.challengeroneapp.data.repository.products

import androidx.lifecycle.LiveData
import com.android.challengeroneapp.data.model.ProductResponse

interface ProductRepository {

    fun getAllProducts(): LiveData<List<ProductResponse>>

    fun getProductById(id: String): LiveData<ProductResponse>

    fun saveMovieToDb(productResponse: ProductResponse)

    fun getAllProductsFromDb(): LiveData<List<ProductResponse>>
}