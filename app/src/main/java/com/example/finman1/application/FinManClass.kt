package com.example.finman1.application

import android.app.Application
import com.example.finman1.database.UserDatabase
import com.example.finman1.database.UserRepository

class FinManClass: Application() {

    companion object {
        lateinit var instance: Application
        lateinit var wordRepositoryGlobal: UserRepository
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        val database by lazy { UserDatabase.getDatabase(this@FinManClass) }
        val repository by lazy { UserRepository(database.userDao()) }

        wordRepositoryGlobal = repository
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}