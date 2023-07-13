package com.example.finman1.database

import androidx.room.*

@Dao
interface FinManDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(finManDataClass: FinManDataClass)

    @Query("SELECT * FROM user_table ORDER BY id DESC")
    suspend fun getAllItem(): List<FinManDataClass>

    @Update
    suspend fun updateGrocery(item: FinManDataClass)

    @Delete
    suspend fun deleteGrocery(item: FinManDataClass)

}