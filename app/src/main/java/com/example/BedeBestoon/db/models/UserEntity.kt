package com.example.BedeBestoon.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val token : String,
    @ColumnInfo(name = "user_id") val userId : Long,
    @ColumnInfo(name = "user_name") var username: String?,
    @ColumnInfo(name = "person_id") var personId : Long,
    @ColumnInfo(name = "first_name") var firstName : String?,
    @ColumnInfo(name = "last_name") var lastName : String?,
    var phone : String?,
    var address : String?,
    @ColumnInfo(name = "postal_code") var postalCode : String?
)