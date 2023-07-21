package com.example.finman1.database

import androidx.room.*

@Dao
interface FinManDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(finManDataClass: FinManDataClass)

    @Query("SELECT * FROM user_table ORDER BY id DESC")
    suspend fun getAllUser(): List<FinManDataClass>

//    @Query("SELECT * FROM user_table WHERE user = :name ")
//    fun getSpecificUser(name: String): List<FinManDataClass>

    @Update
    suspend fun updateUser(item: FinManDataClass)

    @Delete
    suspend fun deleteUser(item: FinManDataClass)



}