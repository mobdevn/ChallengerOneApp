package com.android.challengeroneapp.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.challengeroneapp.data.repository.products.ProductRepositoryImpl
import com.android.challengeroneapp.data.model.ProductResponse
import com.android.challengeroneapp.utils.isOnline

class ProductListDataViewModel(private val repository: ProductRepositoryImpl = ProductRepositoryImpl()) : ViewModel() {

    val allProdcuts = MediatorLiveData<List<ProductResponse>>()

    init {
        getAllProducts()
    }
    var productsLiveData: MutableLiveData<List<ProductResponse>>? = null

    fun getAllSavedProducts() = allProdcuts

    fun getAllProducts() {

        if (!isOnline()) {
            getAllProductsFromDb()
            return
        }

        allProdcuts.addSource(repository.getAllProducts()) {
            if (!it.isNullOrEmpty()) {
                for (prod in it) {
                    repository.saveMovieToDb(prod)
                }
                allProdcuts.postValue(it)
            } else {
                // throw error
            }
        }
    }

    fun getAllProductsFromDb() {
        allProdcuts.addSource(repository.getAllProductsFromDb()) {
            allProdcuts.postValue(it)
        }
    }
}