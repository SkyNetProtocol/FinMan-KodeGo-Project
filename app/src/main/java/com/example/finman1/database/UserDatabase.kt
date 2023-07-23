package com.example.finman1.database

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finman1.database.relations.AssetsTable
import com.example.finman1.database.relations.ExpensesTable
import com.example.finman1.database.relations.IncomeTable
import com.example.finman1.database.relations.LiabilitiesTable

@Database(
    entities = [
        FinManDataClass::class,
        AssetsTable::class,
        ExpensesTable::class,
        IncomeTable::class,
        LiabilitiesTable::class],
    version = 2,
//    autoMigrations = [
//        AutoMigration (from = 1, to = 2)
//    ],
    exportSchema = true)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): FinManDao

    companion object{

        @Volatile
        private var INSTANCE : UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "fin_man_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }

}