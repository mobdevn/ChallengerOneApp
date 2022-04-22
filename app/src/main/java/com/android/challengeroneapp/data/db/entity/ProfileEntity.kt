package com.android.challengeroneapp.data.db.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ProfileEntity(
    @NonNull
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    val title: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val aboutMe: String? = null,
    val gender: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val address: String? = null,
    val pincode: String? = null,
    val city: String? = null,
    val country: String? = null
)