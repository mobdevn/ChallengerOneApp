package com.android.challengeroneapp.data.repository.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.challengeroneapp.data.db.MyShopDao
import com.android.challengeroneapp.data.model.ProductResponse
import com.android.challengeroneapp.db
import com.android.challengeroneapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

class ProductRepositoryImpl : ProductRepository {

    private val apiObject = RetrofitClient.getApiObject()
    private val productsDao: MyShopDao = db.myShopDao()
    private var productById: LiveData<ProductResponse>? = null
    private val productsList: LiveData<List<ProductResponse>>

    init {
        productsList = productsDao.getAll()
    }

    override fun saveMovieToDb(productResponse: ProductResponse) {
        thread {
            productsDao.insert(productResponse)
        }
    }

    override fun getAllProductsFromDb() = productsList

    override fun getAllProducts() : LiveData<List<ProductResponse>> {
        val data = MutableLiveData<List<ProductResponse>>()
        apiObject.getAllProducts().enqueue(object : Callback<List<ProductResponse>> {
            override fun onResponse(
                call: Call<List<ProductResponse>>,
                response: Response<List<ProductResponse>>
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<ProductResponse>>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }

    override fun getProductById(id: String): LiveData<ProductResponse> {
        val data = MutableLiveData<ProductResponse>()
        apiObject.getProductDetails(id).enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>

            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}