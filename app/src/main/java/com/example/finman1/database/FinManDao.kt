package com.example.finman1.database

import androidx.room.*

@Dao
interface FinManDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(finManDataClass: FinManDataClass)

    @Query("SELECT * FROM user_table ORDER BY id DESC")
    suspend fun getAllUser(): List<FinManDataClass>

    @Query("SELECT * FROM user_table WHERE mail = :inputMail ")
    fun getUserByMailAndPass(inputMail: String): List<FinManDataClass>

    @Update
    suspend fun updateUser(item: FinManDataClass)

    @Delete
    suspend fun deleteUser(item: FinManDataClass)



}
//@Query("SELECT * FROM user_table WHERE mail = :inputMail AND pass = :inputPassword ")