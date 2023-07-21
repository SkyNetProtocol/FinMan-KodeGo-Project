package com.example.finman1.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class FinManDataClass(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    @ColumnInfo(name = "first") val firstName: String,
    @ColumnInfo(name = "last") val lastName: String,
    @ColumnInfo(name = "mail") val email: String,
    @ColumnInfo(name = "pass") val password: String,
    @ColumnInfo(name = "conPass")val confirmPassword: String

)
