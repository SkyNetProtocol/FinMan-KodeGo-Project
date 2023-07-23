package com.example.finman1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finman1.database.relations.*

//create new emulator to populate changes. However, if user data is already involved. Use proper migration
@Database(
    entities = [
        FinManDataClass::class,
        AssetsTable::class,
        ExpensesTable::class,
        IncomeTable::class,
        LiabilitiesTable::class,
        BalanceSheetTable::class,
        NetWorthTable::class],
    version = 2,

    exportSchema = true)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): FinManDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

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