package com.example.finman1.database

import com.example.finman1.database.relations.AssetsTable
import com.example.finman1.database.relations.ExpensesTable
import com.example.finman1.database.relations.IncomeTable
import com.example.finman1.database.relations.LiabilitiesTable
import com.example.finman1.dataclass.AssetsData
import kotlinx.coroutines.coroutineScope

class UserRepository(private val userDao:FinManDao) {

    suspend fun delete(user: FinManDataClass){
            userDao.deleteUser(user)
    }

    suspend fun update(user: FinManDataClass) {
        userDao.updateUser(user)
    }

    suspend fun getSpecific(name: String): List<FinManDataClass> {
        return coroutineScope {
            userDao.getUserByMailAndPass(name)
        }
    }

    suspend fun getSpecific1(name: String): List<FinManDataClass> {
        return coroutineScope {
            userDao.getSpecificWords(name)
        }
    }

    suspend fun addUserToDatabase(user: FinManDataClass) {
        return coroutineScope {
            userDao.addUser(user)
        }
    }

    suspend fun addAssetToAssetTable(user: AssetsTable) {
        return coroutineScope {
            userDao.addAssetDao(user)
        }
    }

    suspend fun addIncomeToIncomeTable(user: IncomeTable) {
        return coroutineScope {
            userDao.addIncomeDao(user)
        }
    }

    suspend fun addLiabilityToLiabilityTable(user: LiabilitiesTable) {
        return coroutineScope {
            userDao.addLiabilityDao(user)
        }
    }

    suspend fun addExpenseToExpenseTable(user: ExpensesTable) {
        return coroutineScope {
            userDao.addExpenseDao(user)
        }
    }

    suspend fun getAssets() : List<AssetsTable> {
        return coroutineScope {
            userDao.getAllUser()
        }
    }

    suspend fun getLiability() : List<LiabilitiesTable> {
        return coroutineScope {
            userDao.getAllItemLiability()
        }
    }

    suspend fun getIncome() : List<IncomeTable> {
        return coroutineScope {
            userDao.getAllItemIncome()
        }
    }

    suspend fun getExpense() : List<ExpensesTable> {
        return coroutineScope {
            userDao.getAllItemExpense()
        }
    }


    suspend fun getSpecificDataAsset(name: String): List<AssetsTable> {
        return coroutineScope {
            userDao.getSpecificAsset(name)
        }
    }

}