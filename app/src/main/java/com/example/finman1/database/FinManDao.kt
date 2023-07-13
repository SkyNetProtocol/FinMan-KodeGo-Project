package com.example.finman1.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface FinManDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(finManDataClass: FinManDataClass)

}