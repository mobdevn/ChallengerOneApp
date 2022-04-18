package com.android.challengeroneapp.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.challengeroneapp.data.model.ProductResponse

@Database(entities = [ProductResponse::class], version = 1)
@TypeConverters(GenreIdConverter::class)
abstract class MyShopDatabase : RoomDatabase() {

    abstract fun myShopDao(): MyShopDao

    companion object {
        private val lock = Any()
        private const val DB_NAME = "MyShop"
        private var INSTANCE: MyShopDatabase? = null

        fun getInstance(application: Application): MyShopDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        application,
                        MyShopDatabase::class.java,
                        DB_NAME
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}