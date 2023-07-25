package com.example.finman1.database

import androidx.room.*
import com.example.finman1.database.relations.AssetsTable

@Dao
interface FinManDao {

    @Query("SELECT * FROM user_table WHERE mail = :name ")
    fun getSpecificWords(name: String): List<FinManDataClass>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(finManDataClass: FinManDataClass)

    @Query("SELECT * FROM assets_table ORDER BY id DESC")
    suspend fun getAllUser(): List<AssetsTable>

    @Query("SELECT * FROM user_table WHERE mail = :inputMail ")
    fun getUserByMailAndPass(inputMail: String): List<FinManDataClass>

    @Update
    suspend fun updateUser(item: FinManDataClass)

    @Delete
    suspend fun deleteUser(item: FinManDataClass)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAssetDao(assetsTable: AssetsTable)

}
//@Query("SELECT * FROM user_table WHERE mail = :inputMail AND pass = :inputPassword ")