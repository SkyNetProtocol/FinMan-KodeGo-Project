package com.example.finman1.database

import androidx.room.*
import com.example.finman1.database.relations.AssetsTable
import com.example.finman1.database.relations.ExpensesTable
import com.example.finman1.database.relations.IncomeTable
import com.example.finman1.database.relations.LiabilitiesTable

@Dao
interface FinManDao {

    @Query("SELECT * FROM user_table WHERE mail = :name ")
    fun getSpecificWords(name: String): List<FinManDataClass>

    @Query("SELECT * FROM user_table WHERE mail = :name AND pass = :inputPassword ")
    fun getSpecificAccount(name: String, inputPassword:String): List<FinManDataClass>

    @Query("SELECT * FROM assets_table WHERE quantity = :name ")
    fun getSpecificAsset(name: String): List<AssetsTable>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(finManDataClass: FinManDataClass)

    @Query("SELECT * FROM assets_table ORDER BY id DESC")
    suspend fun getAllUser(): List<AssetsTable>

    @Query("SELECT * FROM income_table ORDER BY id DESC")
    suspend fun getAllItemIncome(): List<IncomeTable>

    @Query("SELECT * FROM liability_table ORDER BY id DESC")
    suspend fun getAllItemLiability(): List<LiabilitiesTable>

    @Query("SELECT * FROM expense_table ORDER BY id DESC")
    suspend fun getAllItemExpense(): List<ExpensesTable>

    @Query("SELECT * FROM user_table WHERE mail = :inputMail ")
    fun getUserByMailAndPass(inputMail: String): List<FinManDataClass>

    @Update
    suspend fun updateUser(item: FinManDataClass)

    @Delete
    suspend fun deleteUser(item: FinManDataClass)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAssetDao(assetsTable: AssetsTable)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLiabilityDao(liabilitiesTable: LiabilitiesTable)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addIncomeDao(incomeTable: IncomeTable)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addExpenseDao(expensesTable: ExpensesTable)

}
//@Query("SELECT * FROM user_table WHERE mail = :inputMail AND pass = :inputPassword ")