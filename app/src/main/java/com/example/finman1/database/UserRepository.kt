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
            userDao.getSpecificUser(name)
        }
    }

    suspend fun addUserToDatabase(user: FinManDataClass) {
        return coroutineScope {
            userDao.addUser(user)
        }
    }


}