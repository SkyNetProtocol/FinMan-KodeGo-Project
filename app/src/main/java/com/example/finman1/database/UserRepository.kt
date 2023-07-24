package com.example.finman1.database

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


}