package com.example.finman1.database.relations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "netWorth_table")
data class NetWorthTable(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "totalIncome") val totalIncome: String,
    @ColumnInfo(name = "totalExpenses") val totalExpenses: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "netWorth") val netWorth: String,
    )
