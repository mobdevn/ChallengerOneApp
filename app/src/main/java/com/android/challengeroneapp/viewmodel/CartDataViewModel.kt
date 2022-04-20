package com.android.challengeroneapp.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.challengeroneapp.data.db.entity.CartEntity
import com.android.challengeroneapp.data.repository.products.ProductRepositoryImpl
import com.android.challengeroneapp.data.model.ProductResponse
import com.android.challengeroneapp.data.repository.cart.CartRepositoryImpl
import com.android.challengeroneapp.utils.isOnline

class CartDataViewModel(private val repository: CartRepositoryImpl = CartRepositoryImpl()) :
    ViewModel() {

    val allProdcuts = MediatorLiveData<List<CartEntity>>()

    init {
        getAllProductsFromDb()
    }

    var cartsLiveData: MutableLiveData<List<CartEntity>>? = null

    fun getAllCartItems() = allProdcuts

    fun getAllProductsFromDb() {
        allProdcuts.addSource(repository.getAllProductsInCart()) {
            allProdcuts.postValue(it)
        }
    }

    suspend fun removeItemFromCart(item: CartEntity) {
        repository.removeItemFromCart(item)
    }
}