package com.android.challengeroneapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.challengeroneapp.data.model.ProductResponse

@Dao
interface MyShopDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(products: ProductResponse)

    @Query("select * from productresponse")
    fun getAll(): LiveData<List<ProductResponse>>

    @Query("select * FROM productresponse WHERE id = :id")
    fun getProductById(id: Int?): ProductResponse
}